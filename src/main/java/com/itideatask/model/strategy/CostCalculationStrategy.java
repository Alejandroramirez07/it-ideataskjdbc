package com.itideatask.model.strategy;

import com.itideatask.model.Project;

public interface CostCalculationStrategy {
    double calculateCost(Project project, double rate);
}
