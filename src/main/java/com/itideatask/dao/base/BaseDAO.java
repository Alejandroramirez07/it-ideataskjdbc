package com.itideatask.dao.base;

import com.itideatask.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T, K> {

    protected Connection getConn() throws SQLException, InterruptedException {
        return ConnectionPool.getConnection();
    }

    protected void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException ignored) {}
        try {
            if (ps != null) ps.close();
        } catch (SQLException ignored) {}
        try {
            if (conn != null) conn.close();
        } catch (SQLException ignored) {}
    }

    public abstract T findById(K key);

    public abstract boolean insert(T obj);

    public abstract boolean update(T obj);

    public abstract boolean delete(K key);

    public List<T> findAll() {
        throw new UnsupportedOperationException("findAll not implemented");
    }
}


