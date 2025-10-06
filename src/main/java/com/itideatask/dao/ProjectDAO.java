package com.itideatask.dao;

import com.itideatask.config.ConnectionPool;
import com.itideatask.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    public static List<Project> findAll() {
        String sql = " SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("project_code"),
                        resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projects;
    }

    public Project findById(int project_code) {
        String sql = " SELECT * FROM projects WHERE project_code=?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Project (
                        resultSet.getInt("project_code"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
