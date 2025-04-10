package test.java;

import main.java.MarsRoverApplication;
import org.junit.jupiter.api.Test;
import test.utils.FakeInputProvider;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class MarsRoverApplicationTest {

    @Test
    void testRunWithFakeInputProvider() {
        FakeInputProvider inputProvider = new FakeInputProvider("5", "5", "1", "2", "n", "x");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            MarsRoverApplication.run(inputProvider);
        } finally {
            System.setOut(originalOut);
        }

        String outputText = output.toString();
        assertTrue(outputText.contains("Rover is at x:1 y:2 facing:n"));
    }

}