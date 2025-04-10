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

    public void moveForward() { attemptMove(direction.moveForward(position)); }

    public void moveBackward() { attemptMove(direction.moveBackward(position)); }

    public void moveLeft() {
        direction = direction.moveLeft();
    }

    public void moveRight() {
        direction = direction.moveRight();
    }

    private void attemptMove(Coordinate target) {
        Coordinate wrapped = surface.wrap(target);
        if (surface.hasObstacle(wrapped)) {
            System.out.printf("Obstacle encountered at x:%d y:%d. Rover stays at current position.%n",
                    wrapped.getX(), wrapped.getY());
        } else {
            position = wrapped;
        }
    }
}
