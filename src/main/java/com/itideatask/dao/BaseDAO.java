package com.itideatask.dao;

import com.itideatask.util.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class BaseDAO<T, K> {
    protected Connection getConnection() throws Exception {
        return ConnectionPool.getConnection();
    }

    protected void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try { if (rs != null) rs.close(); } catch (Exception ignored) {}
        try { if (ps != null) ps.close(); } catch (Exception ignored) {}
        try { if (conn != null) conn.close(); } catch (Exception ignored) {}
    }

    public abstract T findById(K key);
    public abstract boolean insert(T obj);
    public abstract boolean update(T obj);
    public abstract boolean delete(K key);


}

