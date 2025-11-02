package com.itideatask.model.strategy;

import com.itideatask.model.Project;

public class FixedCostStrategy implements CostCalculationStrategy {
    @Override
    public double calculateCost(Project project, double flatRate) {
        return flatRate;
    }
}
