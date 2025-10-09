package com.itideatask.dao.impl;

import com.itideatask.dao.IMonitoringDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.Monitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonitoringDAOImpl extends BaseDAO<Monitoring, Integer> implements IMonitoringDAO {

    @Override
    public Monitoring findById(Integer projectCode) {
        String sql = "SELECT * FROM splunk_monitoring WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, projectCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Monitoring(
                        rs.getInt("project_code"),
                        rs.getString("monitor_comments"),
                        rs.getInt("number_incidents")
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
    public boolean insert(Monitoring monitoring) {
        String sql = "INSERT INTO splunk_monitoring (project_code, monitor_comments, number_incidents) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, monitoring.getProjectCode());
            ps.setString(2, monitoring.getMonitorComments());
            ps.setInt(3, monitoring.getNumberIncidents());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(Monitoring monitoring) {
        String sql = "UPDATE splunk_monitoring SET monitor_comments = ?, number_incidents = ? WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, monitoring.getMonitorComments());
            ps.setInt(2, monitoring.getNumberIncidents());
            ps.setInt(3, monitoring.getProjectCode());

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
        String sql = "DELETE FROM splunk_monitoring WHERE project_code = ?";
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
    public List<Monitoring> findAll() {
        String sql = "SELECT * FROM splunk_monitoring";
        List<Monitoring> monitorings = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                monitorings.add(new Monitoring(
                        rs.getInt("project_code"),
                        rs.getString("monitor_comments"),
                        rs.getInt("number_incidents")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return monitorings;
    }
}
