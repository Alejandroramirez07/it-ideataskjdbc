package com.itideatask.service.Impl;

import com.itideatask.dao.IProjectDAO;
import com.itideatask.model.Project;
import com.itideatask.mybatis.impl.ProjectMyBatisImpl;
import com.itideatask.service.ProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProjectServiceMyBatisImpl implements ProjectService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(ProjectServiceMyBatisImpl.class);

    private final IProjectDAO projectDAO = new ProjectMyBatisImpl();

    @Override
    public Project getAllProjects() {

        List<Project> projects = projectDAO.findAll();

        for (Project project : projects) {
            LOGGER.info(project);
        }

        return null;
    }

    @Override
    public Project getProject(int projectCode) {
        return projectDAO.findById(projectCode);
    }

}
