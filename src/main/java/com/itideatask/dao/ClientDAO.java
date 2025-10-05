package com.itideatask.dao;
import com.itideatask.model.Client;
import com.itideatask.config.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAO {
    public Client findById(String email) {
        try (Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(" SELECT * FROM client_details WHERE email=?")){
            preparedStatement.setString(1, email);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Client (
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("project_code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
