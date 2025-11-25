package com.itideatask.model;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ManagerTest {

    @Test
    public void TestManagerConstructor() {
        Manager manager =new Manager("alejandro.pm",
                "alejandro.pm@solv.com",
                "pass",
                101,
                1
        );

        Assert.assertEquals(manager.getUsername(),"alejandro.pm" );
        Assert.assertNotEquals(manager.getEmail(), "daniel.pm@solv.com");
        Assert.assertNotEquals(manager.getPassword(), "notpassed");

    }

    @Test
    public void testSetUsername() {
        Manager manager =new Manager("alejandro.pm",
                "alejandro.pm@solv.com",
                "pass",
                101,
                1
        );

        manager.setUsername("Alejandro2");
        Assert.assertEquals(manager.getUsername(), "Alejandro2");
    }

    @Test
    public void testToString() {
        Manager manager =new Manager("alejandro.pm",
                "alejandro.pm@solv.com",
                "pass",
                101,
                1
        );

        String result = manager.toString();

        Assert.assertTrue(result.contains("alejandro.pm"));
        Assert.assertTrue(result.contains("alejandro.pm@solv.com"));
        Assert.assertTrue(result.contains("101"));
    }
}
