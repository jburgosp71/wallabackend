package test.java;

import main.java.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    private Direction direction;
    private String expectedDirection = Direction.NORTH;

    @BeforeEach
    void setUp() {
        direction = new Direction(expectedDirection);
    }

    @Test
    public void testDirection() {
        assertEquals(expectedDirection, direction.getDirection());
    }
}