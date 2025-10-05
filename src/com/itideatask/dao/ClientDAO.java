package com.itideatask.dao;

public class ClientDAO {
    public Client findByid(int id) {
        try (Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(" SELECT * FROM users WHERE Id=?")){
            preparedStatement.setIt(1, Id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Client (resultSet.getInt("Id"), resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
