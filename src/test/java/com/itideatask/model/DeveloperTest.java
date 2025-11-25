package com.itideatask.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DeveloperTest {

    private static final Logger LOGGER = LogManager.getLogger(DeveloperTest.class);

    private Developer dev;

    @BeforeMethod
    public void setup() {
        dev = new Developer(
                "Alejandro",
                "danielramirez1022@hotmail.com",
                "thisIsSecret",
                101,
                11,
                1
        );
        LOGGER.info("Constructor built in BeforeMethod");

    }

    @Test
    public void testDeveloperConstructor() {

        Assert.assertEquals(dev.getUsername(), "Alejandro");
        Assert.assertEquals(dev.getEmail(), "danielramirez1022@hotmail.com");
        Assert.assertNotEquals(dev.getEmployeeCode(), 12);
    }

    @Test
    public void testSetUsername() {

        dev.setUsername("Alejandro2");
        Assert.assertEquals(dev.getUsername(), "Alejandro2");
    }

    @Test
    public void testSetEmail() {

        dev.setEmail("daniel@hotmail.com");
        Assert.assertEquals(dev.getEmail(), "daniel@hotmail.com");
    }

    @Test
    public void testToString() {

        String result = dev.toString();

        Assert.assertTrue(result.contains("101"));
        Assert.assertTrue(result.contains("danielramirez1022@hotmail.com"));
        Assert.assertFalse(result.contains("12"));
    }

    @DataProvider(name = "developerData")
    public Object[][] provideDevelopers() {
        return new Object[][] {
                {"alex", "alex@gmail.com"},
                {"john", "john@gmail.com"},
                {"maria", "maria@gmail.com"}
        };
    }

    @Test(dataProvider = "developerData")
    public void testDeveloperEmails(String username, String email) {

        Developer dev = new Developer(
                username,
                email,
                "password",
                101,
                20,
                3
        );

        Assert.assertEquals(dev.getEmail(), email);
    }

    @AfterMethod
    public void teardown() {
        dev = null;
        LOGGER.info("AfterMethod executed");
    }

}
