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
    }

    @Test
    public void testMaxLimitX() {
        assertTrue(ms.isOverMaxLimitX(expectedMaxX));
    }

    @Test
    public void testMinLimitX() {
        assertTrue(ms.isUnderMinLimitX(Surface.ORIGIN));
    }

    @Test
    public void testMaxLimity() {
        assertTrue(ms.isOverMaxLimitY(expectedMaxY));
    }

    @Test
    public void testMinLimitY() {
        assertTrue(ms.isUnderMinLimitY(Surface.ORIGIN));
    }

}