package com.itideatask.service;

import com.itideatask.model.Project;

public interface ProjectService {

    Project getAllProjects();

    Project getProject(int project_code);
}
