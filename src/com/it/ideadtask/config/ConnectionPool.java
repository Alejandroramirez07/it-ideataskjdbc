import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "your_mysql_user";
    private static final String DB_PASSWORD = "your_mysql_password";
    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final long CONNECTION_TIMEOUT_MS = 3000; // 3 seconds timeout

    private static volatile ConnectionPool instance;

    private BlockingQueue<Connection> availableConnections;

    private ConnectionPool() {
        availableConnections = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
        initializePool();
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    private void initializePool() {
        LOGGER.info("Attempting to initialize database connection pool...");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                availableConnections.offer(connection);
                LOGGER.fine("Connection #" + (i + 1) + " created and added to pool.");
            }
            LOGGER.info("Connection pool initialized with " + availableConnections.size() + " connections.");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "MySQL JDBC Driver not found in the classpath.", e);
            throw new RuntimeException("Driver not found.", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to connect to the database. Check URL, user, and password.", e);
            throw new RuntimeException("Database connection failed.", e);
        }
    }

    public Connection getConnection() {
        try {
            Connection connection = availableConnections.poll(CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (connection == null) {
                LOGGER.warning("Connection timeout: No free connection available in the pool.");
                throw new RuntimeException("Failed to acquire connection from pool within " + CONNECTION_TIMEOUT_MS + "ms.");
            }
            return connection;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for a database connection.", e);
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.getAutoCommit()) {
                    connection.setAutoCommit(true);
                }

                if (availableConnections.size() < MAX_POOL_SIZE) {
                    availableConnections.offer(connection);
                } else {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Error resetting or releasing connection. Closing it.", e);
                closeConnection(connection);
            }
        }
    }

    public void shutdown() {
        LOGGER.info("Shutting down connection pool and closing all connections...");
        for (Connection conn : availableConnections) {
            closeConnection(conn);
        }
        availableConnections.clear();
        LOGGER.info("Connection pool shutdown complete.");
    }

    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error closing connection.", e);
            }
        }
    }

    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }
}