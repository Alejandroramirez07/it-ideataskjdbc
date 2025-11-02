package com.itideatask.dao.impl;

import com.itideatask.dao.IProjectDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl extends BaseDAO<Project, Integer> implements IProjectDAO {

    @Override
    public Project findById(Integer projectCode) {

        String sql = "SELECT * FROM projects WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, projectCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Project(
                        rs.getInt("project_code"),
                        rs.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return null;
    }

    @Override
    public boolean insert(Project project) {
        String sql = "INSERT INTO projects (project_code, name) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, project.getProjectCode());
            ps.setString(2, project.getProjectName());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(Project project) {
        String sql = "UPDATE projects SET name = ? WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, project.getProjectName());
            ps.setInt(2, project.getProjectCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean delete(Integer projectCode) {
        String sql = "DELETE FROM projects WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, projectCode);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public List<Project> findAll() {
        String sql = "SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                projects.add(new Project(
                        rs.getInt("project_code"),
                        rs.getString("name")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return projects;
    }
}
