package main.java;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.Coordinate;
import main.java.domain.model.Direction;
import main.java.domain.model.Rover;
import main.java.domain.model.Surface;
import main.java.infrastructure.cli.MarsRoverCLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MarsRoverApplication {

    public static void main(String[] args) {
        runWithScanner(new Scanner(System.in));
    }

    public static void runWithScanner(Scanner reader) {
        int maxSurfaceX = readInt(reader, "Insert horizontal map size:");
        int maxSurfaceY = readInt(reader, "Insert vertical map size:");

        int initialRoverPositionX = readInt(reader, "Insert horizontal initial rover position:");
        int initialRoverPositionY = readInt(reader, "Insert vertical initial rover position:");

        Direction direction = readDirection(reader, "Insert initial rover direction (n = north, e = east, w = west, s = south):");

        Coordinate start = new Coordinate(initialRoverPositionX, initialRoverPositionY);
        Surface surface = new Surface(maxSurfaceX, maxSurfaceY);
        Rover rover = new Rover(start, direction, surface);
        MoveRoverUseCase useCase = new MoveRoverUseCase(rover);
        MarsRoverCLI cli = new MarsRoverCLI(useCase, rover, reader);

        cli.start();
    }

    private static int readInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.println(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    private static Direction readDirection(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            try {
                return Direction.fromShortCode(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid direction. Use one of: n, e, s, w");
            }
        }
    }

}
