package test.java;// test/test.java.MarsRoverTest.java
import main.java.MarsRover;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    @Test
    public void testInitialMapSize() {
        initializeMarsRover(10, 10, 5, 5, "n");

        assertEquals(10, MarsRover.getSizeX());
        assertEquals(10, MarsRover.getSizeY());

    }

    @Test
    public void testInitialPosition() {
        initializeMarsRover(10, 10, 5, 5, "n");

        assertEquals(5, MarsRover.getRoverX());
        assertEquals(5, MarsRover.getRoverY());

    }

    @Test
    public void testInitialDirection() {
        initializeMarsRover(10, 10, 5, 5, "n");

        assertEquals("n", MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandForward() {
        initializeMarsRover(10, 10, 5, 5, "n");

        MarsRover.executeCommand("f");
        assertEquals(5, MarsRover.getRoverX());
        assertEquals(6, MarsRover.getRoverY());
        assertEquals("n", MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandBackward() {
        initializeMarsRover(10, 10, 5, 5, "n");

        MarsRover.executeCommand("b");
        assertEquals(5, MarsRover.getRoverX());
        assertEquals(4, MarsRover.getRoverY());
        assertEquals("n", MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandTurnLeft() {
        initializeMarsRover(10, 10, 5, 5, "n");

        MarsRover.executeCommand("l");
        assertEquals(5, MarsRover.getRoverX());
        assertEquals(5, MarsRover.getRoverY());
        assertEquals("w", MarsRover.getRoverZ());

        MarsRover.executeCommand("l");
        assertEquals("s", MarsRover.getRoverZ());

        MarsRover.executeCommand("l");
        assertEquals("e", MarsRover.getRoverZ());

        MarsRover.executeCommand("l");
        assertEquals("n", MarsRover.getRoverZ());

    }

    @Test
    public void testAfterCommandTurnRight() {
        initializeMarsRover(10, 10, 5, 5, "n");

        MarsRover.executeCommand("r");
        assertEquals(5, MarsRover.getRoverX());
        assertEquals(5, MarsRover.getRoverY());
        assertEquals("e", MarsRover.getRoverZ());

        MarsRover.executeCommand("r");
        assertEquals("s", MarsRover.getRoverZ());

        MarsRover.executeCommand("r");
        assertEquals("w", MarsRover.getRoverZ());

        MarsRover.executeCommand("r");
        assertEquals("n", MarsRover.getRoverZ());

    }

    private void initializeMarsRover(int sizeX, int sizeY, int posX, int posY, String direction) {
        MarsRover.setSizeX(sizeX);
        MarsRover.setSizeY(sizeY);
        MarsRover.setRoverX(posX);
        MarsRover.setRoverY(posY);
        MarsRover.setRoverZ(direction);
    }

}