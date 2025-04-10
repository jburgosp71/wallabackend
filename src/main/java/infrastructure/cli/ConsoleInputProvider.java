package main.java.infrastructure.cli;

import main.java.infrastructure.input.InputProvider;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner;

    public ConsoleInputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public <T> T readValidated(String prompt, Function<String, Optional<T>> parser) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            Optional<T> result = parser.apply(input);

            if (result.isPresent()) {
                return result.get();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

}
