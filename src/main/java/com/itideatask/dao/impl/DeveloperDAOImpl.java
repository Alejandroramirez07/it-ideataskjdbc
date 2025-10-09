package com.itideatask.dao.impl;

import com.itideatask.dao.IDeveloperDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDAOImpl extends BaseDAO<Developer, Integer> implements IDeveloperDAO {

    @Override
    public Developer findById(Integer employeeCode) {
        String sql = "SELECT * FROM developers WHERE employee_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Developer(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("project_code"),
                        rs.getInt("employee_code"),
                        rs.getInt("manager_employee_code")
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
    public boolean insert(Developer developer) {
        String sql = "INSERT INTO developers (username, email, password, project_code, employee_code, manager_employee_code) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, developer.getUsername());
            ps.setString(2, developer.getEmail());
            ps.setString(3, developer.getPassword());
            ps.setInt(4, developer.getProjectCode());
            ps.setInt(5, developer.getEmployeeCode());
            ps.setInt(6, developer.getManagerEmployeeCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(Developer developer) {
        String sql = "UPDATE developers SET username = ?, email = ?, password = ?, project_code = ?, manager_employee_code = ? WHERE employee_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, developer.getUsername());
            ps.setString(2, developer.getEmail());
            ps.setString(3, developer.getPassword());
            ps.setInt(4, developer.getProjectCode());
            ps.setInt(5, developer.getManagerEmployeeCode());
            ps.setInt(6, developer.getEmployeeCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean delete(Integer employeeCode) {
        String sql = "DELETE FROM developers WHERE employee_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeCode);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public List<Developer> findAll() {
        String sql = "SELECT * FROM developers";
        List<Developer> developers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                developers.add(new Developer(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("project_code"),
                        rs.getInt("employee_code"),
                        rs.getInt("manager_employee_code")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return developers;
    }
}
