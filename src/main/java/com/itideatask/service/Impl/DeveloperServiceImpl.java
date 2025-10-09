package com.itideatask.service.Impl;

import com.itideatask.dao.IDeveloperDAO;
import com.itideatask.dao.impl.DeveloperDAOImpl;
import com.itideatask.model.Developer;
import com.itideatask.service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {
    private IDeveloperDAO developerDAO = new DeveloperDAOImpl();
    @Override
    public Developer getDeveloper(int employee_code){
        return developerDAO.findById(employee_code);
    }
}
