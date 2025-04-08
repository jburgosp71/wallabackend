package test.java;

import main.java.Coordinate;
import main.java.Direction;
import main.java.Rover;
import main.java.Surface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    private Surface surface;
    private Coordinate coordinate;
    private Direction directionNorth;
    private Rover roverNorth, roverSouth, roverEast, roverWest;

    private final int expectedMaxX = 10;
    private final int expectedMaxY = 10;
    private final int expectedX = 5;
    private final int expectedY = 5;

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
}