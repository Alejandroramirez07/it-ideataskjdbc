package com.itideatask.dao.impl;

import com.itideatask.dao.IResourcesProjectDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.ResourcesProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResourcesProjectDAOImpl extends BaseDAO<ResourcesProject, Integer> implements IResourcesProjectDAO {

    @Override
    public ResourcesProject findById(Integer projectCode) {
        String sql = "SELECT * FROM resources_invested WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, projectCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new ResourcesProject(
                        rs.getInt("total_spent_usd"),
                        rs.getString("comments_on_spendings"),
                        rs.getInt("project_code"),
                        rs.getInt("report_number")
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
    public boolean insert(ResourcesProject resourcesProject) {
        String sql = "INSERT INTO resources_invested (total_spent_usd, comments_on_spendings, project_code, report_number) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, resourcesProject.getTotalSpentUsd());
            ps.setString(2, resourcesProject.getCommentsSpending());
            ps.setInt(3, resourcesProject.getProjectCode());
            ps.setInt(4, resourcesProject.getReportCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(ResourcesProject resourcesProject) {
        String sql = "UPDATE resources_invested SET total_spent_usd = ?, comments_on_spendings = ?, report_number = ? WHERE project_code = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, resourcesProject.getTotalSpentUsd());
            ps.setString(2, resourcesProject.getCommentsSpending());
            ps.setInt(3, resourcesProject.getReportCode());
            ps.setInt(4, resourcesProject.getProjectCode());

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
        String sql = "DELETE FROM resources_invested WHERE project_code = ?";
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
    public List<ResourcesProject> findAll() {
        String sql = "SELECT * FROM resources_invested";
        List<ResourcesProject> resourcesProjects = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                resourcesProjects.add(new ResourcesProject(
                        rs.getInt("total_spent_usd"),
                        rs.getString("comments_on_spendings"),
                        rs.getInt("project_code"),
                        rs.getInt("report_number")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return resourcesProjects;
    }
}
