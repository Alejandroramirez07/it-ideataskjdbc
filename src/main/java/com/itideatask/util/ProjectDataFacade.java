package com.itideatask.util;

import com.itideatask.model.Monitoring;
import com.itideatask.model.Project;
import com.itideatask.service.ClientService;
import com.itideatask.service.Impl.ClientServiceImpl;
import com.itideatask.service.Impl.MonitoringServiceImpl;
import com.itideatask.service.Impl.ProjectServiceImpl;
import com.itideatask.service.MonitoringService;
import com.itideatask.service.ProjectService;

public class ProjectDataFacade {
    private final ClientService clientService = new ClientServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final MonitoringService monitoringService = new MonitoringServiceImpl();

    public void showProjectOverview(int projectCode) {
        Project project = projectService.getProject(projectCode);
        Monitoring monitoring = monitoringService.getMonitor(projectCode);
        System.out.println("=== Project Overview ===");
        System.out.println(project);
        System.out.println(monitoring);
    }
}
