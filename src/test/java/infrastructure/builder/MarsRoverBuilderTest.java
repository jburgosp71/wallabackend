package test.java.infrastructure.builder;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.Rover;
import main.java.infrastructure.builder.MarsRoverBuilder;
import main.java.infrastructure.input.InputProvider;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class FakeInputProvider implements InputProvider {
    private final Queue<String> inputs;

    FakeInputProvider(String... inputs) {
        this.inputs = new LinkedList<>(List.of(inputs));
    }

    @Override
    public int readInt(String prompt) {
        return Integer.parseInt(Objects.requireNonNull(inputs.poll()));
    }

    @Override
    public String readString(String prompt) {
        return inputs.poll();
    }
}

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