package test.java;// test/test.java.MarsRoverTest.java
import main.java.MarsRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    private final int expectedSizeX = 10;
    private final int expectedSizeY = 10;
    private final int expectedPosX = 5;
    private final int expectedPosY = 5;
    private final String expectedDirection = "n";

    @BeforeEach
    void setUp() {
        MarsRover.initializeRover(expectedSizeX, expectedSizeY, expectedPosX, expectedPosY, expectedDirection);
    }

    @Test
    public void testInitialMapSize() {
        assertEquals(expectedSizeX, MarsRover.getSurfaceMaxX());
        assertEquals(expectedSizeY, MarsRover.getSurfaceMaxY());
    }

    @Test
    public void testInitialPosition() {
        assertEquals(expectedPosX, MarsRover.getCoordinateX());
        assertEquals(expectedPosY, MarsRover.getCoordinateY());
    }

    @Test
    public void testInitialDirection() {
        assertEquals(expectedDirection, MarsRover.getDirection());

    }

    @Test
    public void testAfterCommandForward() {
        MarsRover.executeCommand("f");
        assertEquals(expectedPosX, MarsRover.getCoordinateX());
        assertEquals(6, MarsRover.getCoordinateY());
        assertEquals(expectedDirection, MarsRover.getDirection());

    }

    @Test
    public void testAfterCommandBackward() {
        MarsRover.executeCommand("b");
        assertEquals(expectedPosX, MarsRover.getCoordinateX());
        assertEquals(4, MarsRover.getCoordinateY());
        assertEquals(expectedDirection, MarsRover.getDirection());

    }

    @Test
    public void testAfterCommandTurnLeft() {
        MarsRover.executeCommand("l");
        assertEquals(expectedPosX, MarsRover.getCoordinateX());
        assertEquals(expectedPosY, MarsRover.getCoordinateY());
        assertEquals("w", MarsRover.getDirection());

        MarsRover.executeCommand("l");
        assertEquals("s", MarsRover.getDirection());

        MarsRover.executeCommand("l");
        assertEquals("e", MarsRover.getDirection());

        MarsRover.executeCommand("l");
        assertEquals(expectedDirection, MarsRover.getDirection());

    }

    @Test
    public void testAfterCommandTurnRight() {
        MarsRover.executeCommand("r");
        assertEquals(expectedPosX, MarsRover.getCoordinateX());
        assertEquals(expectedPosY, MarsRover.getCoordinateY());
        assertEquals("e", MarsRover.getDirection());

        MarsRover.executeCommand("r");
        assertEquals("s", MarsRover.getDirection());

        MarsRover.executeCommand("r");
        assertEquals("w", MarsRover.getDirection());

        MarsRover.executeCommand("r");
        assertEquals(expectedDirection, MarsRover.getDirection());

    }

}