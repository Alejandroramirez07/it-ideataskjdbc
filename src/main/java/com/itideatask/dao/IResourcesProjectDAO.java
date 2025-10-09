package com.itideatask.dao;

import com.itideatask.model.ResourcesProject;
import java.util.List;

public interface IResourcesProjectDAO {
    ResourcesProject findById(Integer projectCode);
    boolean insert(ResourcesProject resourcesProject);
    boolean update(ResourcesProject resourcesProject);
    boolean delete(Integer projectCode);
    List<ResourcesProject> findAll();
}
