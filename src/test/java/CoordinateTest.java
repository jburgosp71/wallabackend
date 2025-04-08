package test.java;

import main.java.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    private Coordinate coord;
    private final int expectedX = 5;
    private final int expectedY = 5;

    @BeforeEach
    void setUp() {
        coord = new Coordinate(expectedX, expectedY);
    }

    @Test
    public void testPosX() {
        assertEquals(coord.getX(), expectedX);
    }

    @Test
    public void testPosY() {
        assertEquals(coord.getY(), expectedY);
    }

}