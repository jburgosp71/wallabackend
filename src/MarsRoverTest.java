// test/MarsRoverTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    @Test
    public void testInitialMapSize() {
        MarsRover marsRover = initializeMarsRover(10, 10, 5, 5, "n");

        assertEquals(10, MarsRover.getSizeX());
        assertEquals(10, MarsRover.getSizeY());

    }

    @Test
    public void testInitialPosition() {
        MarsRover marsRover = initializeMarsRover(10, 10, 5, 5, "n");

        assertEquals(5, MarsRover.getRoverX());
        assertEquals(5, MarsRover.getRoverY());

    }

    @Test
    public void testInitialDirection() {
        MarsRover marsRover = initializeMarsRover(10, 10, 5, 5, "n");

        assertEquals("n", MarsRover.getRoverZ());

    }

    private MarsRover initializeMarsRover(int sizeX, int sizeY, int posX, int posY, String direction) {
        MarsRover marsRover = new MarsRover();

        MarsRover.setSizeX(sizeX);
        MarsRover.setSizeY(sizeY);
        MarsRover.setRoverX(posX);
        MarsRover.setRoverY(posY);
        MarsRover.setRoverZ(direction);

        return marsRover;
    }
}