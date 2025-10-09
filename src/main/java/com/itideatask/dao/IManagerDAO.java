package com.itideatask.dao;

import com.itideatask.model.Manager;
import java.util.List;

public interface IManagerDAO {
    Manager findById(Integer employeeCode);
    boolean insert(Manager manager);
    boolean update(Manager manager);
    boolean delete(Integer employeeCode);
    List<Manager> findAll();
}
