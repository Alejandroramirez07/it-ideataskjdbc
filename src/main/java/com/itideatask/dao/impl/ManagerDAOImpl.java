package com.itideatask.dao.impl;

import com.itideatask.dao.IManagerDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAOImpl extends BaseDAO<Manager, Integer> implements IManagerDAO {

    @Override
    public Manager findById(Integer employeeCode) {
        String sql = "SELECT * FROM project_managers WHERE employee_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Manager(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("project_code"),
                        rs.getInt("employee_code")
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
    public boolean insert(Manager manager) {
        String sql = "INSERT INTO project_managers (username, email, password, project_code, employee_code) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getUsername());
            ps.setString(2, manager.getEmail());
            ps.setString(3, manager.getPassword());
            ps.setInt(4, manager.getProjectCode());
            ps.setInt(5, manager.getEmployeeCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(Manager manager) {
        String sql = "UPDATE project_managers SET username = ?, email = ?, password = ?, project_code = ? WHERE employee_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getUsername());
            ps.setString(2, manager.getEmail());
            ps.setString(3, manager.getPassword());
            ps.setInt(4, manager.getProjectCode());
            ps.setInt(5, manager.getEmployeeCode());

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
        String sql = "DELETE FROM project_managers WHERE employee_code = ?";
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
    public List<Manager> findAll() {
        String sql = "SELECT * FROM project_managers";
        List<Manager> managers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                managers.add(new Manager(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("project_code"),
                        rs.getInt("employee_code")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return managers;
    }
}
