package com.itideatask.dao.impl;
import com.itideatask.dao.ClientDAO;
import com.itideatask.model.Client;
import com.itideatask.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public Client findById(String email) {
        String sql = " SELECT * FROM client_details WHERE email=?";
        try (Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
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

    @Override
    public boolean insert(Client client) {
        String sql = "INSERT INTO client_details (email, username, password, project_code) VALUES (?, ?, ?, ?)";

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, client.getEmail());
            preparedStatement.setString(2, client.getUsername());
            preparedStatement.setString(3, client.getPassword());
            preparedStatement.setInt(4, client.getProjectCode());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updatePassword(String email, String newPassword) {
        String sql = "UPDATE client_details SET password = ? WHERE email = ?";

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String email) {
        String sql = "DELETE FROM client_details WHERE email = ?";

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, email);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
