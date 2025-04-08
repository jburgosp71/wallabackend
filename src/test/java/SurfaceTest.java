package test.java;

import main.java.Surface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceTest {
    private Surface ms;
    private final int expectedMaxX = 10;
    private final int expectedMaxY = 10;

    @BeforeEach
    void setUp() {
        ms = new Surface(expectedMaxX, expectedMaxY);
        System.out.println("Ejecutando @BeforeEach");
    }

    @Test
    public void testMaxLimitX() {
        assertTrue(ms.isMaxLimitX(expectedMaxX));
    }

    @Test
    public void testMinLimitX() {
        assertTrue(ms.isMinLimitX(Surface.ORIGIN));
    }

    @Test
    public void testMaxLimity() {
        assertTrue(ms.isMaxLimitY(expectedMaxY));
    }

    @Test
    public void testMinLimitY() {
        assertTrue(ms.isMinLimitY(Surface.ORIGIN));
    }

}