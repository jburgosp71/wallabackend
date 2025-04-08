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
        MarsRover.setSizeX(expectedSizeX);
        MarsRover.setSizeY(expectedSizeY);
        MarsRover.setRoverX(expectedPosX);
        MarsRover.setRoverY(expectedPosY);
        MarsRover.setRoverZ(expectedDirection);
    }

    @Test
    public void testInitialMapSize() {
        assertEquals(expectedSizeX, MarsRover.getSizeX());
        assertEquals(expectedSizeY, MarsRover.getSizeY());
    }

    @Test
    public void testInitialPosition() {
        assertEquals(expectedPosX, MarsRover.getRoverX());
        assertEquals(expectedPosY, MarsRover.getRoverY());
    }

    @Test
    public void testInitialDirection() {
        assertEquals(expectedDirection, MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandForward() {
        MarsRover.executeCommand("f");
        assertEquals(expectedPosX, MarsRover.getRoverX());
        assertEquals(6, MarsRover.getRoverY());
        assertEquals(expectedDirection, MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandBackward() {
        MarsRover.executeCommand("b");
        assertEquals(expectedPosX, MarsRover.getRoverX());
        assertEquals(4, MarsRover.getRoverY());
        assertEquals(expectedDirection, MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandTurnLeft() {
        MarsRover.executeCommand("l");
        assertEquals(expectedPosX, MarsRover.getRoverX());
        assertEquals(expectedPosY, MarsRover.getRoverY());
        assertEquals("w", MarsRover.getRoverZ());

        MarsRover.executeCommand("l");
        assertEquals("s", MarsRover.getRoverZ());

        MarsRover.executeCommand("l");
        assertEquals("e", MarsRover.getRoverZ());

        MarsRover.executeCommand("l");
        assertEquals(expectedDirection, MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandTurnRight() {
        MarsRover.executeCommand("r");
        assertEquals(expectedPosX, MarsRover.getRoverX());
        assertEquals(expectedPosY, MarsRover.getRoverY());
        assertEquals("e", MarsRover.getRoverZ());

        MarsRover.executeCommand("r");
        assertEquals("s", MarsRover.getRoverZ());

        MarsRover.executeCommand("r");
        assertEquals("w", MarsRover.getRoverZ());

        MarsRover.executeCommand("r");
        assertEquals(expectedDirection, MarsRover.getRoverZ());

    }

}