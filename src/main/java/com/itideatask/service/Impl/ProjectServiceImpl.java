package com.itideatask.service.Impl;

import com.itideatask.dao.IProjectDAO;
import com.itideatask.model.Project;
import com.itideatask.dao.impl.ProjectDAOImpl;
import com.itideatask.service.ProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(ProjectServiceImpl.class);

    private final IProjectDAO projectDAOImpl = new ProjectDAOImpl();

    @Override
    public Project getAllProjects() {

        List<Project> projects = projectDAOImpl.findAll();

        for (Project project : projects) {
            LOGGER.info(project);
        }

        return null;
    }

    @Override
    public Project getProject(int project_code){

        return projectDAOImpl.findById(project_code);
    }
}