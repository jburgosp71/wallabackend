package test.java.domain.model;

import main.java.domain.model.Coordinate;
import main.java.domain.model.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testReturnCorrectShortCode() {
        assertEquals("n", Direction.NORTH.getShortCode());
        assertEquals("e", Direction.EAST.getShortCode());
        assertEquals("s", Direction.SOUTH.getShortCode());
        assertEquals("w", Direction.WEST.getShortCode());
    }

    @Test
    void testMoveRightInCorrectOrder() {
        assertEquals(Direction.EAST, Direction.NORTH.moveRight());
        assertEquals(Direction.SOUTH, Direction.EAST.moveRight());
        assertEquals(Direction.WEST, Direction.SOUTH.moveRight());
        assertEquals(Direction.NORTH, Direction.WEST.moveRight());
    }

    @Test
    void testMoveLeftInCorrectOrder() {
        assertEquals(Direction.WEST, Direction.NORTH.moveLeft());
        assertEquals(Direction.NORTH, Direction.EAST.moveLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.moveLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.moveLeft());
    }

    @Test
    void testMoveForwardCorrectly() {
        Coordinate origin = new Coordinate(0, 0);

        assertEquals(new Coordinate(0, 1), Direction.NORTH.moveForward(origin));
        assertEquals(new Coordinate(1, 0), Direction.EAST.moveForward(origin));
        assertEquals(new Coordinate(0, -1), Direction.SOUTH.moveForward(origin));
        assertEquals(new Coordinate(-1, 0), Direction.WEST.moveForward(origin));
    }

    @Test
    void testMoveBackwardCorrectly() {
        Coordinate origin = new Coordinate(0, 0);

        assertEquals(new Coordinate(0, -1), Direction.NORTH.moveBackward(origin));
        assertEquals(new Coordinate(-1, 0), Direction.EAST.moveBackward(origin));
        assertEquals(new Coordinate(0, 1), Direction.SOUTH.moveBackward(origin));
        assertEquals(new Coordinate(1, 0), Direction.WEST.moveBackward(origin));
    }
}