package main.java.domain.model;

import lombok.Getter;

@Getter
public class Rover {
    private Coordinate position;
    private Direction direction;
    private final Surface surface;

    public Rover(Coordinate initial, Direction direction, Surface surface) {
        this.position = initial;
        this.direction = direction;
        this.surface = surface;
    }

    public void moveForward() {
        position = surface.wrap(direction.moveForward(position));
    }

    public void moveBackward() {
        position = surface.wrap(direction.moveBackward(position));
    }

    public void moveLeft() {
        direction = direction.moveLeft();
    }

    public void moveRight() {
        direction = direction.moveRight();
    }
}
