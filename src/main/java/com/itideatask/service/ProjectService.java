package com.itideatask.service;

import com.itideatask.model.Project;
import com.itideatask.dao.ProjectDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProjectService {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(ProjectService.class);
    public Project getAllProjects() {
        List<Project> projects = ProjectDAO.findAll();
        for (Project project : projects) {
            LOGGER.info(project);
        }
        return null;
    }
}
