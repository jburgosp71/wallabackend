package test.java;

import main.java.MarsRoverApplication;
import main.java.infrastructure.input.InputProvider;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverApplicationTest {

    @Test
    void testRunWithFakeInputProvider() {
        FakeInputProvider inputProvider = new FakeInputProvider(
                "5", // maxX
                "5", // maxY
                "1", // initialX
                "2", // initialY
                "n"  // direction
        );

        Scanner scanner = new Scanner(new StringReader("x\n"));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            MarsRoverApplication.run(inputProvider, scanner);
        } finally {
            System.setOut(originalOut);
        }

        String outputText = output.toString();
        assertTrue(outputText.contains("Rover is at x:1 y:2 facing:n"));
    }

    public static class FakeInputProvider implements InputProvider {

        private final Queue<String> inputs;

        public FakeInputProvider(String... inputs) {
            this.inputs = new LinkedList<>();
            this.inputs.addAll(Arrays.asList(inputs));
        }

        @Override
        public int readInt(String prompt) {
            return Integer.parseInt(Objects.requireNonNull(inputs.poll()));
        }

        @Override
        public String readString(String prompt) {
            return inputs.poll();
        }
    }

}