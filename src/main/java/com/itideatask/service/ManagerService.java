package com.itideatask.service;

import com.itideatask.model.Manager;
import com.itideatask.dao.ManagerDAO;

public class ManagerService {
    ManagerDAO managerDAO = new ManagerDAO();

    public Manager getManager(int employee_code){
        return managerDAO.findById(employee_code);
    }
}
