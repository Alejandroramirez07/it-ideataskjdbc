package com.itideatask.dao.impl;

import com.itideatask.dao.iIncomeProjectDAO;
import com.itideatask.dao.base.BaseDAO;
import com.itideatask.model.IncomeProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IncomeProjectDAOImpl extends BaseDAO<IncomeProject, Integer> implements iIncomeProjectDAO {

    @Override
    public IncomeProject findById(Integer reportNumber) {
        String sql = "SELECT * FROM income_projects WHERE report_number = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reportNumber);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new IncomeProject(
                        rs.getFloat("total_income_usd"),
                        rs.getString("comments_on_income"),
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
    public boolean insert(IncomeProject incomeProject) {
        String sql = "INSERT INTO income_projects (total_income_usd, comments_on_income, project_code, report_number) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, incomeProject.getTotalIncomeUsd());
            ps.setString(2, incomeProject.getCommentsIncome());
            ps.setInt(3, incomeProject.getProjectCode());
            ps.setInt(4, incomeProject.getReportCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean update(IncomeProject incomeProject) {
        String sql = "UPDATE income_projects SET total_income_usd = ?, comments_on_income = ?, project_code = ? WHERE report_number = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, incomeProject.getTotalIncomeUsd());
            ps.setString(2, incomeProject.getCommentsIncome());
            ps.setInt(3, incomeProject.getProjectCode());
            ps.setInt(4, incomeProject.getReportCode());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public boolean delete(Integer reportNumber) {
        String sql = "DELETE FROM income_projects WHERE report_number = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reportNumber);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    @Override
    public List<IncomeProject> findAll() {
        String sql = "SELECT * FROM income_projects";
        List<IncomeProject> incomeProjects = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                incomeProjects.add(new IncomeProject(
                        rs.getInt("total_income_usd"),
                        rs.getString("comments_on_income"),
                        rs.getInt("project_code"),
                        rs.getInt("report_number")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return incomeProjects;
    }
}
