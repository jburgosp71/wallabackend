package test.java;

import main.java.Coordinate;
import main.java.Direction;
import main.java.Rover;
import main.java.Surface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    private Surface surface;
    private Coordinate coordinate;
    private Direction directionNorth;
    private Rover roverNorth, roverSouth, roverEast, roverWest;

    private static final int expectedMaxX = 10;
    private static final int expectedMaxY = 10;
    private static final int expectedX = 5;
    private static final int expectedY = 5;

    @BeforeEach
    void setUp() {
        surface = new Surface(expectedMaxX, expectedMaxY);
        coordinate = new Coordinate(expectedX, expectedY);
        directionNorth = new Direction(Direction.NORTH);
        roverNorth = new Rover(surface, coordinate, directionNorth);
        roverSouth = new Rover(surface, new Coordinate(expectedX, expectedY), new Direction(Direction.SOUTH));
        roverWest = new Rover(surface, new Coordinate(expectedX, expectedY), new Direction(Direction.WEST));
        roverEast = new Rover(surface, new Coordinate(expectedX, expectedY), new Direction(Direction.EAST));
    }

    @Test
    void getCoordinate() {
        assertEquals(coordinate, roverNorth.getCoordinate());
        assertEquals(expectedX, roverNorth.getCoordinate().getX());
        assertEquals(expectedY, roverNorth.getCoordinate().getY());
    }

    @Test
    void getDirection() {
        assertEquals(directionNorth, roverNorth.getOrientation());
        assertEquals(Direction.NORTH, roverNorth.getOrientation().getDirection());
    }

    @Test
    void getSurface() {
        assertEquals(surface, roverNorth.getSurface());
        assertEquals(expectedMaxX, roverNorth.getSurface().getMaxX());
        assertEquals(expectedMaxY, roverNorth.getSurface().getMaxY());
        assertEquals(Surface.ORIGIN, roverNorth.getSurface().getMinX());
        assertEquals(Surface.ORIGIN, roverNorth.getSurface().getMinY());
    }

    @Test
    void testMoveWhenCommandIsForward() {
        roverNorth.move(Rover.FORWARD);

        assertEquals(expectedX, roverNorth.getCoordinate().getX());
        assertEquals(Direction.NORTH, roverNorth.getOrientation().getDirection());
        assertEquals(expectedY + 1, roverNorth.getCoordinate().getY());

        roverSouth.move(Rover.FORWARD);
        assertEquals(expectedX, roverSouth.getCoordinate().getX());
        assertEquals(Direction.SOUTH, roverSouth.getOrientation().getDirection());
        assertEquals(expectedY - 1, roverSouth.getCoordinate().getY());

        roverWest.move(Rover.FORWARD);
        assertEquals(expectedX - 1, roverWest.getCoordinate().getX());
        assertEquals(Direction.WEST, roverWest.getOrientation().getDirection());
        assertEquals(expectedY, roverWest.getCoordinate().getY());

        roverEast.move(Rover.FORWARD);
        assertEquals(expectedX + 1, roverEast.getCoordinate().getX());
        assertEquals(Direction.EAST, roverEast.getOrientation().getDirection());
        assertEquals(expectedY, roverEast.getCoordinate().getY());
    }

    @Test
    void testMoveWhenCommandIsBackward() {
        roverNorth.move(Rover.BACKWARD);

        assertEquals(expectedX, roverNorth.getCoordinate().getX());
        assertEquals(Direction.NORTH, roverNorth.getOrientation().getDirection());
        assertEquals(expectedY - 1, roverNorth.getCoordinate().getY());

        roverSouth.move(Rover.BACKWARD);
        assertEquals(expectedX, roverSouth.getCoordinate().getX());
        assertEquals(Direction.SOUTH, roverSouth.getOrientation().getDirection());
        assertEquals(expectedY + 1, roverSouth.getCoordinate().getY());

        roverWest.move(Rover.BACKWARD);
        assertEquals(expectedX + 1, roverWest.getCoordinate().getX());
        assertEquals(Direction.WEST, roverWest.getOrientation().getDirection());
        assertEquals(expectedY, roverWest.getCoordinate().getY());

        roverEast.move(Rover.BACKWARD);
        assertEquals(expectedX - 1, roverEast.getCoordinate().getX());
        assertEquals(Direction.EAST, roverEast.getOrientation().getDirection());
        assertEquals(expectedY, roverEast.getCoordinate().getY());
    }

    @Test
    void testMoveWhenCommandIsLeft() {
        roverNorth.move(Rover.LEFT);

        assertEquals(expectedX, roverNorth.getCoordinate().getX());
        assertEquals(expectedY, roverNorth.getCoordinate().getY());
        assertEquals(Direction.WEST, roverNorth.getOrientation().getDirection());

        roverSouth.move(Rover.LEFT);
        assertEquals(expectedX, roverSouth.getCoordinate().getX());
        assertEquals(expectedY, roverSouth.getCoordinate().getY());
        assertEquals(Direction.EAST, roverSouth.getOrientation().getDirection());

        roverWest.move(Rover.LEFT);
        assertEquals(expectedX, roverWest.getCoordinate().getX());
        assertEquals(expectedY, roverWest.getCoordinate().getY());
        assertEquals(Direction.SOUTH, roverWest.getOrientation().getDirection());

        roverEast.move(Rover.LEFT);
        assertEquals(expectedX, roverEast.getCoordinate().getX());
        assertEquals(expectedY, roverEast.getCoordinate().getY());
        assertEquals(Direction.NORTH, roverEast.getOrientation().getDirection());
    }

    @Test
    void testMoveWhenCommandIsRight() {
        roverNorth.move(Rover.RIGHT);

        assertEquals(expectedX, roverNorth.getCoordinate().getX());
        assertEquals(expectedY, roverNorth.getCoordinate().getY());
        assertEquals(Direction.EAST, roverNorth.getOrientation().getDirection());

        roverSouth.move(Rover.RIGHT);
        assertEquals(expectedX, roverSouth.getCoordinate().getX());
        assertEquals(expectedY, roverSouth.getCoordinate().getY());
        assertEquals(Direction.WEST, roverSouth.getOrientation().getDirection());

        roverWest.move(Rover.RIGHT);
        assertEquals(expectedX, roverWest.getCoordinate().getX());
        assertEquals(expectedY, roverWest.getCoordinate().getY());
        assertEquals(Direction.NORTH, roverWest.getOrientation().getDirection());

        roverEast.move(Rover.RIGHT);
        assertEquals(expectedX, roverEast.getCoordinate().getX());
        assertEquals(expectedY, roverEast.getCoordinate().getY());
        assertEquals(Direction.SOUTH, roverEast.getOrientation().getDirection());
    }

    static Stream<Arguments> provideRoverTestData() {
        Surface providerSurface = new Surface(expectedMaxX,expectedMaxY);
        return Stream.of(
            Arguments.of(new Coordinate(expectedX, expectedMaxY), Direction.NORTH, Rover.FORWARD, expectedX, providerSurface.getMinY()),
            Arguments.of(new Coordinate(expectedMaxX, expectedY), Direction.EAST, Rover.FORWARD, providerSurface.getMinX(), expectedY),
            Arguments.of(new Coordinate(expectedX, providerSurface.getMinY()), Direction.SOUTH, Rover.FORWARD, expectedX, expectedMaxY),
            Arguments.of(new Coordinate(providerSurface.getMinX(), expectedY), Direction.WEST, Rover.FORWARD, expectedMaxX, expectedY),
            Arguments.of(new Coordinate(expectedX, providerSurface.getMinY()), Direction.NORTH, Rover.BACKWARD, expectedX, expectedMaxY),
            Arguments.of(new Coordinate(providerSurface.getMinX(), expectedY), Direction.EAST, Rover.BACKWARD, expectedMaxX, expectedY),
            Arguments.of(new Coordinate(expectedX, expectedMaxY), Direction.SOUTH, Rover.BACKWARD, expectedX, providerSurface.getMinY()),
            Arguments.of(new Coordinate(expectedMaxX, expectedY), Direction.WEST, Rover.BACKWARD, providerSurface.getMinX(), expectedY)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRoverTestData")
    void testRoverMoveOverSurfaceLimits(
            Coordinate initialCoordinate,
            String initialDirection,
            String command,
            int expectedFinalX,
            int expectedFinalY) {
        Rover roverOnLimits = new Rover(surface, initialCoordinate, new Direction(initialDirection));

        roverOnLimits.move(command);
        assertEquals(expectedFinalX, roverOnLimits.getCoordinate().getX());
        assertEquals(initialDirection, roverOnLimits.getOrientation().getDirection());
        assertEquals(expectedFinalY, roverOnLimits.getCoordinate().getY());
    }

}