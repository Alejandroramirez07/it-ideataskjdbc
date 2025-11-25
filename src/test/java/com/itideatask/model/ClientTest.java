package com.itideatask.model;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ClientTest {

    @Test
    public void setPasswordTest() {
        Client client = new Client("Daniel",
                "daniel.ramirez@solvd.co",
                "Secret",
                101
        );

        client.setPassword("notThatSecret");

        Assert.assertEquals(client.getPassword(), "notThatSecret");
    }

    @Test
    public void testSetProjectCode() {
        Client client = new Client("Daniel",
                "daniel.ramirez@solvd.co",
                "Secret",
                101
        );

        client.setProjectCode(999);

        Assert.assertEquals(client.getProjectCode(), 999);
    }

}
