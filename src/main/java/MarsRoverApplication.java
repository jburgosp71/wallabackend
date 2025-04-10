package main.java;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.*;
import main.java.infrastructure.builder.MarsRoverBuilder;
import main.java.infrastructure.cli.ConsoleInputProvider;
import main.java.infrastructure.cli.MarsRoverCLI;
import main.java.infrastructure.cli.MarsRoverController;
import main.java.infrastructure.input.InputProvider;

import java.util.Scanner;

public class MarsRoverApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputProvider inputProvider = new ConsoleInputProvider(scanner);
        run(inputProvider);
    }

    public static void run(InputProvider inputProvider) {
        MarsRoverBuilder builder = new MarsRoverBuilder(inputProvider);
        MoveRoverUseCase useCase = builder.buildUseCase();
        Rover rover = builder.getRoverFromUseCase(useCase);

        MarsRoverController controller = new MarsRoverCLI(useCase, rover, inputProvider);
        controller.start();
    }

}
