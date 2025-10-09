package com.itideatask.dao;

import com.itideatask.model.Cloud;

public interface CloudDAO {
    Cloud findById(int gcp_project_code);
}
