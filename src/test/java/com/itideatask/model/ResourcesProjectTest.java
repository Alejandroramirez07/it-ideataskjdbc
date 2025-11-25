package com.itideatask.model;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ResourcesProjectTest {

    @Test
    public void testResourcesProjectConstructor() {
        ResourcesProject resourcesProject = new ResourcesProject(
                75000.00F,
                "Cleaning databases",
                101,
                2025
        );

        Assert.assertEquals(resourcesProject.getReportCode(), 2025);
        Assert.assertFalse(resourcesProject.getTotalSpentUsd()<10000.00F);
        Assert.assertNotEquals(resourcesProject.getCommentsSpending(), "Different comment");

    }

    @Test
    public void testToString() {
        ResourcesProject resourcesProject = new ResourcesProject(
                75000.00F,
                "Cleaning databases",
                101,
                2025
        );

        String result = resourcesProject.toString();

        Assert.assertFalse(result.contains("AWS Services"));

    }
}
