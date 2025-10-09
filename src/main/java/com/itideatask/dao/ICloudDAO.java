package com.itideatask.dao;

import com.itideatask.model.Cloud;

public interface ICloudDAO {
    Cloud findById(Integer gcpProjectCode);
    boolean insert(Cloud cloud);
    boolean update(Cloud cloud);
    boolean delete(Integer gcpProjectCode);

}

