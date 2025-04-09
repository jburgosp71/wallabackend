package test.java.domain.model;

import main.java.domain.model.Coordinate;
import main.java.domain.model.Direction;
import main.java.domain.model.Rover;
import main.java.domain.model.Surface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Surface surface;
    private Rover rover;

    @BeforeEach
    void setUp() {
        surface = new Surface(5, 5);
        rover = new Rover(new Coordinate(2, 2), Direction.NORTH, surface);
    }

    private static Stream<Arguments> forwardAndBackwardProvider() {
        return Stream.of(
                Arguments.of(Direction.NORTH, new Coordinate(2, 2), "forward", new Coordinate(2, 3), Direction.NORTH),
                Arguments.of(Direction.EAST, new Coordinate(2, 2), "forward", new Coordinate(3, 2), Direction.EAST),
                Arguments.of(Direction.NORTH, new Coordinate(5, 5), "forward", new Coordinate(5, 0), Direction.NORTH),
                Arguments.of(Direction.EAST, new Coordinate(5, 0), "forward", new Coordinate(0, 0), Direction.EAST),
                Arguments.of(Direction.SOUTH, new Coordinate(0, 0), "forward", new Coordinate(0, 5), Direction.SOUTH),
                Arguments.of(Direction.WEST, new Coordinate(0, 0), "forward", new Coordinate(5, 0), Direction.WEST),
                Arguments.of(Direction.NORTH, new Coordinate(2, 2), "backward", new Coordinate(2, 1), Direction.NORTH),
                Arguments.of(Direction.WEST, new Coordinate(2, 2), "backward", new Coordinate(3, 2), Direction.WEST),
                Arguments.of(Direction.NORTH, new Coordinate(0, 0), "backward", new Coordinate(0, 5), Direction.NORTH),
                Arguments.of(Direction.EAST, new Coordinate(0, 0), "backward", new Coordinate(5, 0), Direction.EAST),
                Arguments.of(Direction.SOUTH, new Coordinate(0, 5), "backward", new Coordinate(0, 0), Direction.SOUTH),
                Arguments.of(Direction.WEST, new Coordinate(5, 0), "backward", new Coordinate(0, 0), Direction.WEST)
        );
    }

    @ParameterizedTest
    @MethodSource("forwardAndBackwardProvider")
    void testMoveForwardAndBackward(Direction initialDirection,
                                    Coordinate initialPosition,
                                    String movementType,
                                    Coordinate expectedPosition,
                                    Direction expectedDirection) {
        rover = new Rover(initialPosition, initialDirection, surface);

        if (movementType.equals("forward")) {
            rover.moveForward();
        } else if (movementType.equals("backward")) {
            rover.moveBackward();
        }

        assertEquals(expectedPosition, rover.getPosition());
        assertEquals(expectedDirection, rover.getDirection());
    }

    @Test
    void testTurnLeftCorrectly() {
        rover.moveLeft();
        assertEquals(Direction.WEST, rover.getDirection());
        rover.moveLeft();
        assertEquals(Direction.SOUTH, rover.getDirection());
        rover.moveLeft();
        assertEquals(Direction.EAST, rover.getDirection());
        rover.moveLeft();
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testTurnRightCorrectly() {
        rover.moveRight();
        assertEquals(Direction.EAST, rover.getDirection());
        rover.moveRight();
        assertEquals(Direction.SOUTH, rover.getDirection());
        rover.moveRight();
        assertEquals(Direction.WEST, rover.getDirection());
        rover.moveRight();
        assertEquals(Direction.NORTH, rover.getDirection());
    }
}