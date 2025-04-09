package test.java.domain.model;

import main.java.domain.model.Coordinate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    public void testCreationCoordinate() {
        Coordinate expectedCoordinate = new Coordinate(5, 5);
        assertEquals(Coordinate.class, expectedCoordinate.getClass());
    }

    @Test
    void testCreateCoordinateWithCorrectValues() {
        Coordinate c = new Coordinate(5, 10);
        assertEquals(5, c.getX());
        assertEquals(10, c.getY());
    }

    @Test
    void testMoveCoordinateByDelta() {
        Coordinate original = new Coordinate(3, 7);
        Coordinate moved = original.move(2, -3);

        assertEquals(5, moved.getX());
        assertEquals(4, moved.getY());
    }

    @Test
    void moveShouldNotAffectOriginalCoordinate() {
        Coordinate original = new Coordinate(0, 0);
        Coordinate moved = original.move(1, 1);

        assertEquals(0, original.getX());
        assertEquals(0, original.getY());

        assertEquals(1, moved.getX());
        assertEquals(1, moved.getY());
    }

    @Test
    void coordinatesWithSameValuesShouldBeEqual() {
        Coordinate a = new Coordinate(4, 4);
        Coordinate b = new Coordinate(4, 4);

        assertEquals(a, b);
    }

    @Test
    void coordinatesWithDifferentValuesShouldNotBeEqual() {
        Coordinate a = new Coordinate(4, 5);
        Coordinate b = new Coordinate(5, 4);

        assertNotEquals(a, b);
    }
}