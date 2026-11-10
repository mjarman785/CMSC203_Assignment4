/*
 * Class: CMSC203
 * Instructor: Khandan Monshi
 * Description: Assignment 4: management company with driver
 * Due: 11/11/2026
 * Platform/compiler: Win11 26H2 build 26430.9767 / openjdk 21.0.1 (Microsoft provided)
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Michael Jarman
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyJUnitTestStudent {
    Property p1;
    Property p2;
    Property p3;
    Property p4;

    @BeforeEach
    void setup () {
        p1 = new Property("Green Village", "Rocktown", 500.33, "Jimmy Jackson");
        p2 = new Property("Old Village", "Silver River", 6600.22, "Jamie Thompson");
        p3 = new Property("Orange Orchard", "Sanetown", 222.00, "Paul Kee");
        p4 = new Property();
    }

    @AfterEach
    void teardown () {
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
    }

    @Test
    void setPropertyNameTest () {
        p4.setPropertyName("Name");
        assertEquals("Name", p4.getPropertyName());
    }

    @Test
    void setCityNameTest () {
        p4.setCity("City");
        assertEquals("City", p4.getCity());
    }

    @Test
    void setRentAmountTest () {
        p4.setRentAmount(1337.67);
        assertEquals(1337.67, p4.getRentAmount());
    }

    @Test
    void setOwnerTest () {
        p4.setOwner ("Owner");
        assertEquals("Owner", p4.getOwner());
    }

    @Test
    void defaultConstructorTest () {
        assertEquals("Default Property", p4.getPropertyName());
        assertEquals("Default City", p4.getCity());
        assertEquals(420420420420420.00, p4.getRentAmount());
        assertEquals("Default Owner", p4.getOwner());
    }

    @Test
    void checkParamConstructorTestOne () {
        assertEquals("Green Village", p1.getPropertyName());
        assertEquals("Rocktown", p1.getCity());
        assertEquals(500.33, p1.getRentAmount());
        assertEquals("Jimmy Jackson", p1.getOwner());
    }

    @Test
    void checkParamConstructorTestTwo () {
        assertEquals("Old Village", p2.getPropertyName());
        assertEquals("Silver River", p2.getCity());
        assertEquals(6600.22, p2.getRentAmount());
        assertEquals("Jamie Thompson", p2.getOwner());
    }

    @Test
    void checkParamConstructorTestThree () {
        assertEquals("Orange Orchard", p3.getPropertyName());
        assertEquals("Sanetown", p3.getCity());
        assertEquals(222.00, p3.getRentAmount());
        assertEquals("Paul Kee", p3.getOwner());
    }

    @Test
    void checkCopyConstructorFieldTest () {
        p4 = new Property(p1);
        assertEquals("Green Village", p4.getPropertyName());
        assertEquals("Rocktown", p4.getCity());
        assertEquals(500.33, p4.getRentAmount());
        assertEquals("Jimmy Jackson", p4.getOwner());
    }
}
