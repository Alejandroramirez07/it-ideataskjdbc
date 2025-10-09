package com.itideatask.dao;

import com.itideatask.model.Project;

import java.util.List;

public interface ProjectDAO {
    Project findById(int project_code);
}
