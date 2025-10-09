package com.itideatask.dao;

import com.itideatask.model.IncomeProject;
import java.util.List;

public interface iIncomeProjectDAO {
    IncomeProject findById(Integer reportNumber);
    boolean insert(IncomeProject incomeProject);
    boolean update(IncomeProject incomeProject);
    boolean delete(Integer reportNumber);
    List<IncomeProject> findAll();
}
