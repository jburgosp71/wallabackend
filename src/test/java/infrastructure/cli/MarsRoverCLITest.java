package test.java.infrastructure.cli;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.Coordinate;
import main.java.domain.model.Direction;
import main.java.domain.model.Rover;
import main.java.domain.model.Surface;
import main.java.infrastructure.cli.MarsRoverCLI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

class MarsRoverCLITest {

    private static Stream<Arguments> validCommandsProvider() {
        return Stream.of(
                Arguments.of("f\nx\n", "Rover is at x:0 y:1 facing:n"),
                Arguments.of("b\nx\n", "Rover is at x:0 y:5 facing:n"),
                Arguments.of("l\nx\n", "Rover is at x:0 y:0 facing:w"),
                Arguments.of("r\nx\n", "Rover is at x:0 y:0 facing:e")
        );
    }

    @ParameterizedTest
    @MethodSource("validCommandsProvider")
    void testExecuteCommandPrintCorrectRoverState(String input, String expectedOutput) {
        String output = simulateCLI(input);

        assertTrue(output.contains(expectedOutput));
        assertTrue(output.contains("Enter command (f, b, l, r, x):"));
    }

    @Test
    void testHandleInvalidCommandAndPrintErrorMessage() {
        String simulatedInput = "z\nx\n";

        String output = simulateCLI(simulatedInput);

        assertTrue(output.contains("Invalid input: z"));
        assertTrue(output.contains("Enter command (f, b, l, r, x):"));
    }

    private String simulateCLI(String simulatedInput) {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Rover rover = new Rover(new Coordinate(0, 0), Direction.NORTH, new Surface(5, 5));
        MoveRoverUseCase useCase = new MoveRoverUseCase(rover);
        MarsRoverCLI cli = new MarsRoverCLI(useCase, rover, new Scanner(System.in));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        cli.start();

        return outputStream.toString();
    }

}
