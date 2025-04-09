package main.java.infrastructure.cli;

import main.java.application.command.MoveCommand;
import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.Rover;

import java.util.Scanner;

public class MarsRoverCLI {
    private final MoveRoverUseCase useCase;
    private final Rover rover;
    private final Scanner scanner;

    public MarsRoverCLI(MoveRoverUseCase useCase, Rover rover, Scanner scanner) {
        this.useCase = useCase;
        this.rover = rover;
        this.scanner = scanner;
    }

    public void start() {
        String input;

        do {
            System.out.print("Enter command (f, b, l, r, x): ");
            if (!scanner.hasNextLine()) break;
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("x")) {
                try {
                    useCase.execute(new MoveCommand(input.charAt(0)));
                    showRoverPositionAndDirection();
                } catch (Exception e) {
                    System.out.println("Invalid input: " + input);
                }
            }

        } while (!input.equalsIgnoreCase("x"));
        showRoverPositionAndDirection();
    }

    private void showRoverPositionAndDirection() {
        System.out.printf("Rover is at x:%d y:%d facing:%s%n",
                rover.getPosition().getX(),
                rover.getPosition().getY(),
                rover.getDirection().getShortCode());
    }

}
