package com.itideatask.dao.impl;

import com.itideatask.dao.CloudDAO;
import com.itideatask.util.ConnectionPool;
import com.itideatask.model.Cloud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CloudDAOImpl implements CloudDAO {

    @Override
    public Cloud findById (int gcp_project_code) {
        String sql = " SELECT * FROM general_clouds WHERE gcp_project_code=?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, gcp_project_code);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Cloud (
                        resultSet.getInt("gcp_project_code"),
                        resultSet.getInt("aws_project_code"),
                        resultSet.getInt("azure_project_code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
