package com.itideatask.model.strategy;

import com.itideatask.model.Project;

public class TimeBasedCostStrategy implements CostCalculationStrategy {
    @Override
    public double calculateCost(Project project, double dailyRate) {

        int days = 10;
        return days * dailyRate * 8;
    }
}
