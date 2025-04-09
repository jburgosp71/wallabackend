package test.java;

import main.java.MarsRoverApplication;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverApplicationTest {

    @Test
    public void testValidInput() {
        String input = String.join("\n",
                "5",    // maxSurfaceX
                "5",    // maxSurfaceY
                "1",    // initialX
                "2",    // initialY
                "n",    // direction
                "x"     // exit command
        );
        Scanner scanner = new Scanner(new StringReader(input));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverApplication.runWithScanner(scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Enter command (f, b, l, r, x)"), "Rover is at x:1 y:2 facing:n");
    }

    @Test
    public void testInvalidIntegerInput() {
        String input = String.join("\n",
                "five", "5",     // invalid then valid maxSurfaceX
                "six", "5",      // invalid then valid maxSurfaceY
                "a", "1",        // invalid then valid initialX
                "b", "2",        // invalid then valid initialY
                "n",             // direction
                "x"              // exit
        );
        Scanner scanner = new Scanner(new StringReader(input));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverApplication.runWithScanner(scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Please enter a valid integer."));
        assertTrue(output.contains("Rover is at x:1 y:2 facing:n"));
    }

    @Test
    public void testInvalidDirectionInput() {
        String input = String.join("\n",
                "5",     // maxSurfaceX
                "5",     // maxSurfaceY
                "1",     // initialX
                "2",     // initialY
                "z", "e",// invalid direction, then valid
                "x"      // exit
        );
        Scanner scanner = new Scanner(new StringReader(input));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverApplication.runWithScanner(scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Invalid direction. Use one of: n, e, s, w"));
        assertTrue(output.contains("Rover is at x:1 y:2 facing:e"));
    }

}