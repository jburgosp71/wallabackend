package main.java.infrastructure.cli;

import main.java.application.command.MoveCommand;
import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.Rover;
import main.java.infrastructure.input.InputProvider;

import java.util.Optional;
import java.util.Set;

public class MarsRoverCLI implements MarsRoverController{
    private final MoveRoverUseCase useCase;
    private final Rover rover;
    private final InputProvider inputProvider;

    private static final Set<Character> VALID_COMMANDS = Set.of('f', 'b', 'l', 'r', 'x');

    public MarsRoverCLI(MoveRoverUseCase useCase, Rover rover, InputProvider inputProvider) {
        this.useCase = useCase;
        this.rover = rover;
        this.inputProvider = inputProvider;
    }

    public void start() {
        char input;

        do {
            showRoverPositionAndDirection();

            input = inputProvider.readValidated("Enter command (f, b, l, r, x):", MarsRoverCLI::validateCommand);

            if (input != 'x') {
                useCase.execute(new MoveCommand(input));
            }

        } while (input != 'x');

        showRoverPositionAndDirection();
    }

    private static Optional<Character> validateCommand(String input) {
        if (input == null || input.trim().isEmpty()) return Optional.empty();

        char ch = Character.toLowerCase(input.trim().charAt(0));
        return VALID_COMMANDS.contains(ch) ? Optional.of(ch) : Optional.empty();
    }

    private void showRoverPositionAndDirection() {
        showObstacles();
        System.out.printf("Rover is at x:%d y:%d facing:%s%n",
                rover.getPosition().getX(),
                rover.getPosition().getY(),
                rover.getDirection().getShortCode());
    }

    private void showObstacles() {
        if (!rover.getSurface().getObstacles().isEmpty()) {
            System.out.println("Obstacles on the map:");
            rover.getSurface().getObstacles().forEach(c ->
                    System.out.printf(" - Obstacle at x:%d y:%d%n", c.getX(), c.getY()));
        }
    }

}
