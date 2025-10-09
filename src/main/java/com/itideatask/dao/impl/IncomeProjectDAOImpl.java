package com.itideatask.dao.impl;

import com.itideatask.dao.IncomeProjectDAO;
import com.itideatask.util.ConnectionPool;
import com.itideatask.model.IncomeProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IncomeProjectDAOImpl implements IncomeProjectDAO {

    @Override
    public IncomeProject findById(int report_number) {
        String sql = " SELECT * FROM income_projects WHERE report_number=?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, report_number);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new IncomeProject (
                        resultSet.getInt("total_income_usd"),
                        resultSet.getString("comments_on_income"),
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
