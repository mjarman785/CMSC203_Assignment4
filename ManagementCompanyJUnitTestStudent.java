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

public class ManagementCompanyJUnitTestStudent {
    Property p1;
    Property p2;
    Property p3;
    Property p4;
    Property p5;
    Property[] pArray;
    Property[] pArrayPartial;
    ManagementCompany m1;
    ManagementCompany m1partial;
    ManagementCompany mx;

    @BeforeEach
    void setup () {
        p1 = new Property("Green Village", "Rocktown", 500.33, "Jimmy Jackson");
        p2 = new Property("Old Village", "Silver River", 6600.22, "Jamie Thompson");
        p3 = new Property("Orange Orchard", "Sanetown", 222.00, "Paul Kee");
        p4 = new Property("Quaint Town", "Blacksburg", 50.00, "John Mamo");
        p5 = new Property("Russia II", "Redmond", 5000.21, "Steven Gates");
        pArray = new Property[]{p1, p2, p3, p4, p5};
        pArrayPartial = new Property[]{p1, p3, p5};
        m1 = new ManagementCompany("Delightful Apartments", "123-45-6789", pArray, 5);
        m1partial = new ManagementCompany("Missing Apartments", "9876-54-321", pArrayPartial, 3);
        mx = new ManagementCompany();
    }

    @AfterEach
    void teardown () {
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        p5 = null;
        pArray = null;
        pArrayPartial = null;
        m1 = null;
        m1partial = null;
        mx = null;
    }

    @Test
    void totalRentTest () {
        assertEquals(12372.76, m1.totalRent());
    }

    @Test
    void copyManagementCompanyAddressTest () {
        ManagementCompany m2 = new ManagementCompany(m1);
        assertNotSame(m1, m2);
    }

    @Test
    void copyManagementCompanyDeepCopyTest () {
        ManagementCompany m2 = new ManagementCompany(m1);
        assertTrue(m1.checkDeepCopy(m2));
    }

    @Test
    void copyManagementCompanyDeepCopySameTest () {
        assertFalse(m1.checkDeepCopy(m1));
    }

    @Test
    void countPropertyTest () {
        assertEquals(5, m1.getPropertyCount());
    }

    @Test
    void copyManagementCompanyDeepCopyPartialTest () {
        ManagementCompany m2 = new ManagementCompany(m1partial);
        assertTrue(m1partial.checkDeepCopy(m2));
    }

    @Test
    void toStringTest () {
        String fullOutput = "Management Company: Delightful Apartments (Tax ID: 123-45-6789)\n" +
                "Properties:\n" +
                " 0: Green Village, Rocktown, Rent: $500.33, Owner: Jimmy Jackson\n" +
                " 1: Old Village, Silver River, Rent: $6,600.22, Owner: Jamie Thompson\n" +
                " 2: Orange Orchard, Sanetown, Rent: $222.00, Owner: Paul Kee\n" +
                " 3: Quaint Town, Blacksburg, Rent: $50.00, Owner: John Mamo\n" +
                " 4: Russia II, Redmond, Rent: $5,000.21, Owner: Steven Gates\n" +
                "Total Rent: $12,372.76";
        assertEquals(fullOutput, m1.toString());
    }

    @Test
    void setNameTest () {
        mx.setName("Name");
        assertEquals("Name", mx.getName());
    }

    @Test
    void setTaxIdTest () {
        mx.setTaxId("000-00-0000");
        assertEquals("000-00-0000", mx.getTaxId());
    }

    @Test
    void setPropertyTest () {
        mx.setProperties(pArray);
        assertEquals(pArray[0], mx.getProperty(0));
        assertEquals(pArray[1], mx.getProperty(1));
        assertEquals(pArray[2], mx.getProperty(2));
        assertEquals(pArray[3], mx.getProperty(3));
        assertEquals(pArray[4], mx.getProperty(4));
    }
}