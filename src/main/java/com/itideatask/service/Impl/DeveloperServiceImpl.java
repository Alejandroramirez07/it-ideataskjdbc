package com.itideatask.service.Impl;

import com.itideatask.dao.DeveloperDAO;
import com.itideatask.dao.impl.DeveloperDAOImpl;
import com.itideatask.model.Developer;
import com.itideatask.service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {
    private DeveloperDAO developerDAO = new DeveloperDAOImpl();
    @Override
    public Developer getDeveloper(int employee_code){
        return developerDAO.findById(employee_code);
    }
}
