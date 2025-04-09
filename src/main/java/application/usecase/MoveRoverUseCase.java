package main.java.application.usecase;

import lombok.RequiredArgsConstructor;
import main.java.application.command.MoveCommand;
import main.java.domain.model.Rover;

@RequiredArgsConstructor
public class MoveRoverUseCase {
    private final Rover rover;

    public void execute(MoveCommand command) {
        switch (command.instruction()) {
            case 'f' -> rover.moveForward();
            case 'b' -> rover.moveBackward();
            case 'l' -> rover.moveLeft();
            case 'r' -> rover.moveRight();
            default -> throw new IllegalArgumentException("Invalid command");
        }
    }
}
