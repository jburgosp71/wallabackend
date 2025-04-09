package test.java.application.usecase;

import main.java.application.command.MoveCommand;
import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveRoverUseCaseTest {

    private MoveRoverUseCase useCase;
    private Rover rover;

    @BeforeEach
    void setUp() {
        Surface surface = new Surface(5, 5);
        Coordinate start = new Coordinate(2, 2);
        Direction direction = Direction.NORTH;
        rover = new Rover(start, direction, surface);
        useCase = new MoveRoverUseCase(rover);
    }

    @Test
    void testMoveForward() {
        useCase.execute(new MoveCommand('f'));
        assertEquals(new Coordinate(2, 3), rover.getPosition());
    }

    @Test
    void testMoveBackward() {
        useCase.execute(new MoveCommand('b'));
        assertEquals(new Coordinate(2, 1), rover.getPosition());
    }

    @Test
    void testMoveLeft() {
        useCase.execute(new MoveCommand('l'));
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testMoveRight() {
        useCase.execute(new MoveCommand('r'));
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testThrowExceptionOnInvalidCommand() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> useCase.execute(new MoveCommand('z')));

        assertEquals("Invalid command", exception.getMessage());
    }
}