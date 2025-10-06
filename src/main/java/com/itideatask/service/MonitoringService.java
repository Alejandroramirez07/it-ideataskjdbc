package com.itideatask.service;


import com.itideatask.dao.MonitoringDAO;
import com.itideatask.model.Monitoring;

public class MonitoringService {
    MonitoringDAO monitoringDAO = new MonitoringDAO();
    
    public Monitoring getMonitor(int project_code){
        return monitoringDAO.findById(project_code);
    }
}
