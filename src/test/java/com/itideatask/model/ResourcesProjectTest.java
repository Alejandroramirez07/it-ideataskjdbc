package com.itideatask.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ResourcesProjectTest {

    private static final Logger LOGGER = LogManager.getLogger(ResourcesProjectTest.class);

    ResourcesProject resourcesProject;

    @BeforeMethod

    public void setuo() {
        resourcesProject = new ResourcesProject(
            75000.00F,
            "Cleaning databases",
            101,
            2025
        );
        LOGGER.info("Constructor built in BeforeMethod");
    }

    @Test
    public void testResourcesProjectConstructor() {

        Assert.assertEquals(resourcesProject.getReportCode(), 2025);
        Assert.assertFalse(resourcesProject.getTotalSpentUsd()<10000.00F);
        Assert.assertNotEquals(resourcesProject.getCommentsSpending(), "Different comment");

    }

    @Test
    public void testToString() {

        String result = resourcesProject.toString();

        Assert.assertFalse(result.contains("AWS Services"));

    }

    @AfterMethod
    public void teardown() {
        resourcesProject = null;
        LOGGER.info("AfterMethod executed");
    }
}
