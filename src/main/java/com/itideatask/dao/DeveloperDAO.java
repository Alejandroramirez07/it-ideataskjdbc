package com.itideatask.dao;

import com.itideatask.config.ConnectionPool;
import com.itideatask.model.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeveloperDAO {
    public Developer findById(int employeeCode) {
        String sql = " SELECT * FROM developers WHERE employee_code=?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, employeeCode);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Developer (
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("project_code"),
                        resultSet.getInt("employee_code"),
                        resultSet.getInt("manager_employee_code")
                        );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
