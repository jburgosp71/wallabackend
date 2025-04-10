package main.java;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.*;
import main.java.infrastructure.builder.MarsRoverBuilder;
import main.java.infrastructure.cli.ConsoleInputProvider;
import main.java.infrastructure.cli.MarsRoverCLI;
import main.java.infrastructure.cli.MarsRoverController;
import main.java.infrastructure.input.InputProvider;

import java.util.Scanner;

public class MarsRoverApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputProvider inputProvider = new ConsoleInputProvider(scanner);
        run(inputProvider, scanner);
    }

    public static void run(InputProvider inputProvider, Scanner scanner) {
        MarsRoverBuilder builder = new MarsRoverBuilder(inputProvider);
        MoveRoverUseCase useCase = builder.buildUseCase();
        Rover rover = builder.getRoverFromUseCase(useCase);

        MarsRoverController controller = new MarsRoverCLI(useCase, rover, scanner);
        controller.start();
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputProvider inputProvider = new ConsoleInputProvider(scanner);
        MarsRoverBuilder builder = new MarsRoverBuilder(inputProvider);
        MoveRoverUseCase useCase = builder.buildUseCase();
        Rover rover = builder.getRoverFromUseCase(useCase);

        MarsRoverController controller = new MarsRoverCLI(useCase, rover, scanner);
        controller.start();
    }

    public static void main(String[] args) {
        runWithScanner(new Scanner(System.in));
    }

    public static void runWithScanner(Scanner reader) {
        int maxSurfaceX = readInt(reader, "Insert horizontal map size:");
        int maxSurfaceY = readInt(reader, "Insert vertical map size:");
        List<Coordinate> obstacles = List.of(
                new Coordinate(1, 2),
                new Coordinate(3, 3)
        );

        int initialRoverPositionX = readInt(reader, "Insert horizontal initial rover position:");
        int initialRoverPositionY = readInt(reader, "Insert vertical initial rover position:");

        Direction direction = readDirection(reader, "Insert initial rover direction (n = north, e = east, w = west, s = south):");

        Coordinate start = new Coordinate(initialRoverPositionX, initialRoverPositionY);
        Surface surface = createSurfaceWithObstacles(maxSurfaceX, maxSurfaceY, obstacles);
        Rover rover = new Rover(start, direction, surface);
        MoveRoverUseCase useCase = new MoveRoverUseCase(rover);
        MarsRoverCLI cli = new MarsRoverCLI(useCase, rover, reader);

        cli.start();
    }

    private static Surface createSurfaceWithObstacles(int maxSurfaceX, int maxSurfaceY, List<Coordinate> obstacles) {
        SurfaceBuilder surfaceBuilder = new SurfaceBuilder(maxSurfaceX, maxSurfaceY);

        for (Coordinate obstacle : obstacles) {
            surfaceBuilder.addObstacle(obstacle);
        }

        return surfaceBuilder.build();
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
     */

}
