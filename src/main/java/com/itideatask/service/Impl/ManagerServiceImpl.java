package com.itideatask.service.Impl;

import com.itideatask.dao.IManagerDAO;
import com.itideatask.model.Manager;
import com.itideatask.dao.impl.ManagerDAOImpl;
import com.itideatask.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    IManagerDAO managerDAO = new ManagerDAOImpl();

    @Override
    public Manager getManager(int employee_code){
        return managerDAO.findById(employee_code);
    }
}
