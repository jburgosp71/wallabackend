package test.java.domain.model;

import main.java.domain.model.Surface;
import main.java.domain.model.Coordinate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SurfaceTest {

    Surface surface = new Surface(5, 5); // mapa de 6x6 (0 a 5)

    @Test
    void testWrapCoordinatesWithinBounds() {
        assertEquals(new Coordinate(2, 3), surface.wrap(new Coordinate(2, 3)));
    }

    @Test
    void testWrapCoordinatesThatExceedMaxX() {
        assertEquals(new Coordinate(0, 3), surface.wrap(new Coordinate(6, 3)));
        assertEquals(new Coordinate(1, 3), surface.wrap(new Coordinate(7, 3)));
    }

    @Test
    void testWrapCoordinatesThatExceedMaxY() {
        assertEquals(new Coordinate(2, 0), surface.wrap(new Coordinate(2, 6)));
        assertEquals(new Coordinate(2, 1), surface.wrap(new Coordinate(2, 7)));
    }

    @Test
    void testWrapNegativeCoordinatesX() {
        assertEquals(new Coordinate(5, 3), surface.wrap(new Coordinate(-1, 3)));
        assertEquals(new Coordinate(4, 3), surface.wrap(new Coordinate(-2, 3)));
    }

    @Test
    void testWrapNegativeCoordinatesY() {
        assertEquals(new Coordinate(2, 5), surface.wrap(new Coordinate(2, -1)));
        assertEquals(new Coordinate(2, 4), surface.wrap(new Coordinate(2, -2)));
    }

    @Test
    void testWrapNegativeCoordinatesBothAxes() {
        assertEquals(new Coordinate(5, 5), surface.wrap(new Coordinate(-1, -1)));
        assertEquals(new Coordinate(0, 0), surface.wrap(new Coordinate(6, 6)));
    }
}