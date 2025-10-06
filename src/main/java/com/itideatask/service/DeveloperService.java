package com.itideatask.service;

import com.itideatask.dao.DeveloperDAO;
import com.itideatask.model.Developer;

public class DeveloperService {
    private DeveloperDAO developerDAO = new DeveloperDAO();

    public Developer getDeveloper(int employee_code){
        return developerDAO.findById(employee_code);
    }
}
