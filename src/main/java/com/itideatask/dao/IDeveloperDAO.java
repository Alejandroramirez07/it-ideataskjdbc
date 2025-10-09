package com.itideatask.dao;

import com.itideatask.model.Developer;
import java.util.List;

public interface IDeveloperDAO {
    Developer findById(Integer employeeCode);
    boolean insert(Developer developer);
    boolean update(Developer developer);
    boolean delete(Integer employeeCode);
    List<Developer> findAll();
}