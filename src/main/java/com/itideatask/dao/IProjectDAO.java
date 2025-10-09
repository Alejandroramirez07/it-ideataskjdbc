package com.itideatask.dao;

import com.itideatask.model.Project;
import java.util.List;

public interface IProjectDAO {
    Project findById(Integer projectCode);
    boolean insert(Project project);
    boolean update(Project project);
    boolean delete(Integer projectCode);
    List<Project> findAll();
}
