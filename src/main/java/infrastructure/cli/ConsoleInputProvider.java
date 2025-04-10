package main.java.infrastructure.cli;

import main.java.infrastructure.input.InputProvider;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    public String readString(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                String value = scanner.nextLine().trim().toLowerCase();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid string.");
                scanner.nextLine();
            }
        }
    }

}
