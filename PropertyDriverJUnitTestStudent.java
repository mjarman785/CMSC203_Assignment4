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

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyDriverJUnitTestStudent {
    @Test
    void exitTest () {
        PrintStream output = System.out;
        ByteArrayOutputStream baOutput = new ByteArrayOutputStream();
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        try {
            System.setOut(new PrintStream(baOutput));
            PropertyDriver.main(new String[0]);
            String result = baOutput.toString();
            assertTrue(result.contains("Goodbye"));
        } finally {
            System.setOut(output);
        }
    }

    @Test
    void tooManyPropertiesTest () {
        PrintStream output = System.out;
        ByteArrayOutputStream baOutput = new ByteArrayOutputStream();
        String input = "1\nProp1\nCity1\n100\nOwner1\n1\nProp2\nCity2\n100\nOwner2\n" +
                "1\nProp3\nCity3\n100\nOwner3\n1\nProp4\nCity4\n100\nOwner4\n" +
                "1\nProp5\nCity5\n100\nOwner5\n1\nProp6\nCity6\n100\nOwner6\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        try {
            System.setOut(new PrintStream(baOutput));
            PropertyDriver.main(new String[0]);
            String result = baOutput.toString();
            assertTrue(result.contains("Failed to add new property"));
        } finally {
            System.setOut(output);
        }
    }

    @Test
    void checkRentTest () {
        PrintStream output = System.out;
        ByteArrayOutputStream baOutput = new ByteArrayOutputStream();
        String input = "1\nProp1\nCity1\n100\nOwner1\n1\nProp2\nCity2\n100\nOwner2\n" +
                "1\nProp3\nCity3\n100\nOwner3\n1\nProp4\nCity4\n100\nOwner4\n" +
                "1\nProp5\nCity5\n100\nOwner5\n1\nProp6\nCity6\n100\nOwner6\n3\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        try {
            System.setOut(new PrintStream(baOutput));
            PropertyDriver.main(new String[0]);
            String result = baOutput.toString();
            assertTrue(result.contains("Total Rent: $500.00"));
        } finally {
            System.setOut(output);
        }
    }

    @Test
    void checkUserInputTest () {
        PrintStream output = System.out;
        ByteArrayOutputStream baOutput = new ByteArrayOutputStream();
        String input = "1\nProp1\nCity1\n100\nOwner1\n1\nProp2\nCity2\n100\nOwner2\n" +
                "1\nProp3\nCity3\n100\nOwner3\n1\nProp4\nCity4\n100\nOwner4\n" +
                "1\nProp5\nCity5\n100\nOwner5\n1\nProp6\nCity6\naaaaaa\nbb3481\n1223bv\n100\nOwner6\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        try {
            System.setOut(new PrintStream(baOutput));
            PropertyDriver.main(new String[0]);
            String result = baOutput.toString();
            assertTrue(result.contains("Invalid input, please try again:"));
        } finally {
            System.setOut(output);
        }
    }

    @Test
    void checkPropertyListTest () {
        PrintStream output = System.out;
        ByteArrayOutputStream baOutput = new ByteArrayOutputStream();
        String input = "1\nProp1\nCity1\n100\nOwner1\n1\nProp2\nCity2\n100\nOwner2\n" +
                "1\nProp3\nCity3\n100\nOwner3\n1\nProp4\nCity4\n100\nOwner4\n" +
                "1\nProp5\nCity5\n100\nOwner5\n1\nProp6\nCity6\n100\nOwner6\n2\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        try {
            System.setOut(new PrintStream(baOutput));
            PropertyDriver.main(new String[0]);
            String result = baOutput.toString();
            assertTrue(result.contains("Prop1"));
            assertTrue(result.contains("Prop2"));
            assertTrue(result.contains("Prop3"));
            assertTrue(result.contains("Prop4"));
            assertTrue(result.contains("Prop5"));
            assertFalse(result.contains("Prop6"));
            System.out.println(result);
        } finally {
            System.setOut(output);
        }
    }
}
