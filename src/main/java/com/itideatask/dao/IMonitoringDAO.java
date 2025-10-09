package com.itideatask.dao;

import com.itideatask.model.Monitoring;
import java.util.List;

public interface IMonitoringDAO {
    Monitoring findById(Integer projectCode);
    boolean insert(Monitoring monitoring);
    boolean update(Monitoring monitoring);
    boolean delete(Integer projectCode);
    List<Monitoring> findAll();
}
