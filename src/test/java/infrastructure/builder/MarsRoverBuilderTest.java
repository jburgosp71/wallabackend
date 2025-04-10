package test.java.infrastructure.builder;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.Rover;
import main.java.infrastructure.builder.MarsRoverBuilder;
import main.java.infrastructure.input.InputProvider;
import org.junit.jupiter.api.Test;
import test.utils.FakeInputProvider;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverBuilderTest {

    @Test
    void buildsUseCaseCorrectly() {
        InputProvider input = new FakeInputProvider("5", "5", "1", "1", "n");
        MarsRoverBuilder builder = new MarsRoverBuilder(input);

        MoveRoverUseCase useCase = builder.buildUseCase();
        Rover rover = builder.getRoverFromUseCase(useCase);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals("n", rover.getDirection().getShortCode());
    }
}