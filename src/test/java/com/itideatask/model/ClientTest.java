package com.itideatask.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ClientTest {

    private static final Logger LOGGER = LogManager.getLogger(ClientTest.class);

    Client client;

    @BeforeMethod
    public void setup() {
        client = new Client("Daniel",
                "daniel.ramirez@solvd.co",
                "Secret",
                101
        );
        LOGGER.info("Constructor built in BeforeMethod");
    }

    @Test
    public void setPasswordTest() {


        client.setPassword("notThatSecret");

        Assert.assertEquals(client.getPassword(), "notThatSecret");
    }

    @Test
    public void testSetProjectCode() {

        client.setProjectCode(999);

        Assert.assertEquals(client.getProjectCode(), 999);
    }

    @DataProvider(name = "ClientData")
    public Object[][] provideDevelopers() {
        return new Object[][] {
                {"alexei", "alexei@gmail.com"},
                {"john", "john@hotmail.com"},
                {"maria", "maria@gmail.com"},
                {"Alejandro", "danielramirez1022@hotmail.com"}
        };
    }

    @Test(dataProvider = "ClientData")
    public void testClientEmails(String username, String email) {

        Client client = new Client(username,
                email,
                "Secret",
                101
        );

        Assert.assertEquals(client.getEmail(), email);
    }

    @AfterMethod
    public void teardown() {
        client = null;
        LOGGER.info("AfterMethod executed");
    }

}
