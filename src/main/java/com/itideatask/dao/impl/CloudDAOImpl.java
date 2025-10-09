package com.itideatask.dao.impl;

import com.itideatask.dao.ICloudDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.Cloud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CloudDAOImpl extends BaseDAO<Cloud, Integer> implements ICloudDAO {

    @Override
    public Cloud findById(Integer gcpProjectCode) {
        String sql = "SELECT * FROM general_clouds WHERE gcp_project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, gcpProjectCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Cloud(
                        rs.getInt("gcp_project_code"),
                        rs.getInt("aws_project_code"),
                        rs.getInt("azure_project_code")
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
    public boolean insert(Cloud cloud) {
        String sql = "INSERT INTO general_clouds (gcp_project_code, aws_project_code, azure_project_code) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cloud.getGcpProjectCode());
            ps.setInt(2, cloud.getAwsProjectCode());
            ps.setInt(3, cloud.getAzureProjectCode());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(Cloud cloud) {
        String sql = "UPDATE general_clouds SET aws_project_code = ?, azure_project_code = ? WHERE gcp_project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cloud.getAwsProjectCode());
            ps.setInt(2, cloud.getAzureProjectCode());
            ps.setInt(3, cloud.getGcpProjectCode());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean delete(Integer gcpProjectCode) {
        String sql = "DELETE FROM general_clouds WHERE gcp_project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, gcpProjectCode);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public List<Cloud> findAll() {
        String sql = "SELECT * FROM general_clouds";
        List<Cloud> clouds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clouds.add(new Cloud(
                        rs.getInt("gcp_project_code"),
                        rs.getInt("aws_project_code"),
                        rs.getInt("azure_project_code")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return clouds;
    }
}
