package com.itideatask.service.Impl;


import com.itideatask.dao.IMonitoringDAO;
import com.itideatask.dao.impl.MonitoringDAOImpl;
import com.itideatask.model.Monitoring;
import com.itideatask.service.MonitoringService;

public class MonitoringServiceImpl implements MonitoringService {
    IMonitoringDAO monitoringDAO = new MonitoringDAOImpl();

    @Override
    public Monitoring getMonitor(int project_code){
        return monitoringDAO.findById(project_code);
    }
}
