package com.itideatask.dao;

import com.itideatask.model.Monitoring;

public interface MonitoringDAO {
    Monitoring findById(int project_code);
}
