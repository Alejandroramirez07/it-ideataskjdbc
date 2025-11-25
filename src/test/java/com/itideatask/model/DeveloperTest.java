package com.itideatask.model;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class DeveloperTest {
    @Test
    public void testDeveloperConstructor() {
        Developer dev = new Developer(
                "Alejandro",
                "danielramirez1022@hotmail.com",
                "thisIsSecret",
                101,
                11,
                1);

        Assert.assertEquals(dev.getUsername(), "Alejandro");
        Assert.assertEquals(dev.getEmail(), "danielramirez1022@hotmail.com");
        Assert.assertNotEquals(dev.getEmployeeCode(), 12);
    }

    @Test
    public void testSetUsername() {
        Developer dev = new Developer(
                "Alejandro",
                "danielramirez1022@hotmail.com",
                "thisissecret",
                101,
                11,
                1);

        dev.setUsername("Alejandro2");
        Assert.assertEquals(dev.getUsername(), "Alejandro2");
    }

    @Test
    public void testSetEmail() {
        Developer dev = new Developer(
                "Alejandro",
                "danielramirez1022@hotmail.com",
                "thisissecret",
                101,
                11,
                1);
        dev.setEmail("daniel@hotmail.com");
        Assert.assertEquals(dev.getEmail(), "daniel@hotmail.com");
    }

    @Test
    public void testToString() {
        Developer dev = new Developer("emma",
                "emma@mail.com",
                "pw",
                55,
                100,
                200);
        String result = dev.toString();

        Assert.assertTrue(result.contains("emma"));
        Assert.assertTrue(result.contains("emma@mail.com"));
        Assert.assertTrue(result.contains("55"));
    }

}
