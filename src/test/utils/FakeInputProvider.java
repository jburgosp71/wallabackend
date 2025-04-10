package test.utils;

import java.util.*;
import main.java.infrastructure.input.InputProvider;

public class FakeInputProvider implements InputProvider {
    private final Queue<String> inputs;

    public FakeInputProvider(String... inputs) {
        this.inputs = new LinkedList<>(Arrays.asList(inputs));
    }

    @Override
    public int readInt(String prompt) {
        return Integer.parseInt(Objects.requireNonNull(inputs.poll()));
    }

    @Override
    public <T> T readValidated(String prompt, java.util.function.Function<String, Optional<T>> validator) {
        while (!inputs.isEmpty()) {
            String input = inputs.poll();
            Optional<T> result = validator.apply(input);
            if (result.isPresent()) {
                return result.get();
            }
            System.out.println("Invalid input: " + input);
        }
        throw new NoSuchElementException("No valid input provided");
    }
}

