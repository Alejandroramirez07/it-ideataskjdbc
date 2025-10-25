package com.itideatask.mybatis;

import com.itideatask.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    Project findById(@Param("projectCode") int projectCode);

    boolean insert(Project project);

    boolean update(Project project);

    boolean delete(@Param("projectCode") int projectCode);

    List<Project> findAll();
}