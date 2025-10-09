package com.itideatask.dao.impl;

import com.itideatask.dao.ResourcesProjectDAO;
import com.itideatask.util.ConnectionPool;
import com.itideatask.model.ResourcesProject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResourcesProjectDAOImpl implements ResourcesProjectDAO {

    @Override
    public ResourcesProject findById(int project_code) {
        String sql = " SELECT * FROM resources_invested WHERE project_code=?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, project_code);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new ResourcesProject(
                        resultSet.getInt("total_spent_usd"),
                        resultSet.getString("comments_on_spendings"),
                        resultSet.getInt("project_code"),
                        resultSet.getInt("report_number")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
