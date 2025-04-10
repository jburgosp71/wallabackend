package main.java.infrastructure.builder;

import main.java.application.usecase.MoveRoverUseCase;
import main.java.domain.model.*;
import main.java.infrastructure.input.InputProvider;

import java.util.List;
import java.util.Optional;

public class MarsRoverBuilder {
    private final InputProvider inputProvider;

    public MarsRoverBuilder(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public MoveRoverUseCase buildUseCase() {
        int maxSurfaceX = inputProvider.readInt("Insert horizontal map size:");
        int maxSurfaceY = inputProvider.readInt("Insert vertical map size:");

        List<Coordinate> obstacles = List.of(
                new Coordinate(1, 2),
                new Coordinate(3, 3)
        );

        int posX = inputProvider.readInt("Insert horizontal initial rover position:");
        int posY = inputProvider.readInt("Insert vertical initial rover position:");

        Direction direction = inputProvider.readValidated(
                "Insert initial rover direction (n = north, e = east, w = west, s = south):",
                input -> {
                    try {
                        return Optional.of(Direction.fromShortCode(input));
                    } catch (IllegalArgumentException e) {
                        return Optional.empty();
                    }
                }
        );

        Surface surface = new SurfaceBuilder(maxSurfaceX, maxSurfaceY)
                .addObstacle(obstacles.get(0))
                .addObstacle(obstacles.get(1))
                .build();

        Rover rover = new Rover(new Coordinate(posX, posY), direction, surface);

        return new MoveRoverUseCase(rover);
    }

    public Rover getRoverFromUseCase(MoveRoverUseCase useCase) {
        return useCase.getRover();
    }
}
