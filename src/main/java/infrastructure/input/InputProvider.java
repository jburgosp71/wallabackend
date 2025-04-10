package main.java.infrastructure.input;

import java.util.Optional;
import java.util.function.Function;

public interface InputProvider {
    int readInt(String prompt);
    <T> T readValidated(String prompt, Function<String, Optional<T>> parser);
}
