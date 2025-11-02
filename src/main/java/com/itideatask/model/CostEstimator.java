package com.itideatask.model;

import com.itideatask.model.strategy.CostCalculationStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CostEstimator {

    private static final Logger LOGGER = LogManager.getLogger(CostEstimator.class);

    private CostCalculationStrategy strategy;

    public CostEstimator(CostCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CostCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double estimate(Project project, double rate) {
        if (strategy == null) {
            LOGGER.warn("No cost calculation strategy set!");
            return 0.0;
        }
        double cost = strategy.calculateCost(project, rate);
        LOGGER.info("Estimated cost for project '" + project.getProjectName() + "' (code " + project.getProjectCode() + "): $" + cost);
        return cost;
    }
}
