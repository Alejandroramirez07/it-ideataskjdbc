package com.itideatask.dao.impl;

import com.itideatask.dao.MonitoringDAO;
import com.itideatask.util.ConnectionPool;
import com.itideatask.model.Monitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MonitoringDAOImpl implements MonitoringDAO {

    @Override
    public Monitoring findById(int project_code) {
        String sql = " SELECT * FROM splunk_monitoring WHERE project_code=?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, project_code);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Monitoring (
                        resultSet.getInt("project_code"),
                        resultSet.getString("monitor_comments"),
                        resultSet.getInt("number_incidents")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
