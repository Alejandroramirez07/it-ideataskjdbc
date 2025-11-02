package com.itideatask.model.strategy;

import com.itideatask.model.Project;

public class HourlyCostStrategy implements CostCalculationStrategy {
    @Override
    public double calculateCost(Project project, double hourlyRate) {

        int estimatedHours = 160;
        return estimatedHours * hourlyRate;
    }
}
