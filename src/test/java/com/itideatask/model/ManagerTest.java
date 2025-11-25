package com.itideatask.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ManagerTest {

    private static final Logger LOGGER = LogManager.getLogger(ManagerTest.class);

    private Manager manager;

    @BeforeMethod
    public void setup() {
        manager =new Manager("alejandro.pm",
                "alejandro.pm@solv.com",
                "pass",
                101,
                1
        );
        LOGGER.info("Constructor built in BeforeMethod");

    }

    @Test
    public void TestManagerConstructor() {

        Assert.assertEquals(manager.getUsername(),"alejandro.pm" );
        Assert.assertNotEquals(manager.getEmail(), "daniel.pm@solv.com");
        Assert.assertNotEquals(manager.getPassword(), "notpassed");

    }

    @Test
    public void testSetUsername() {

        manager.setUsername("Alejandro2");
        Assert.assertEquals(manager.getUsername(), "Alejandro2");
    }

    @Test
    public void testToString() {

        String result = manager.toString();

        Assert.assertTrue(result.contains("alejandro.pm"));
        Assert.assertTrue(result.contains("alejandro.pm@solv.com"));
        Assert.assertTrue(result.contains("101"));
    }

    @AfterMethod
    public void teardown() {
        manager = null;
        LOGGER.info("AfterMethod executed");
    }
}
