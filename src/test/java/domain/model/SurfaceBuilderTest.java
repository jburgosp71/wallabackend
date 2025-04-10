package test.java.domain.model;

import main.java.domain.model.Coordinate;
import main.java.domain.model.Surface;
import main.java.domain.model.SurfaceBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SurfaceBuilderTest {

    @Test
    void testBuildSurfaceWithObstacles() {
        Coordinate obstacle1 = new Coordinate(1, 2);
        Coordinate obstacle2 = new Coordinate(3, 4);

        Surface surface = new SurfaceBuilder(5, 5)
                .addObstacle(obstacle1)
                .addObstacle(obstacle2)
                .build();

        assertEquals(5, surface.getMaxX());
        assertEquals(5, surface.getMaxY());
        assertTrue(surface.hasObstacle(obstacle1));
        assertTrue(surface.hasObstacle(obstacle2));
        assertEquals(List.of(obstacle1, obstacle2), surface.getObstacles());
    }

    @Test
    void testSurfaceWithoutObstacles() {
        Surface surface = new SurfaceBuilder(3, 3).build();

        assertFalse(surface.hasObstacle(new Coordinate(0, 0)));
        assertTrue(surface.getObstacles().isEmpty());
    }
}