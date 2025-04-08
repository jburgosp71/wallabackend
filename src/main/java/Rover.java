package main.java;

import lombok.Getter;

@Getter
public class Rover {
    public static final String FORWARD = "f";
    public static final String BACKWARD = "b";
    public static final String RIGHT = "r";
    public static final String LEFT = "l";

    private final Coordinate coordinate;
    private final Direction orientation;
    private final Surface surface;

    public Rover(Surface surface, Coordinate coordinate, Direction orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.surface = surface;
    }

    public void move(String command) {
        if (command.equals("f")) {
            moveForward();
        }
        if (command.equals("b")) {
            moveBackward();
        }
        if (command.equals("l")) {
            moveLeft();
        }
        if (command.equals("r")) {
            moveRight();
        }
    }

    private void moveRight() {
        switch (orientation.getDirection()) {
            case Direction.NORTH:
                orientation.setDirection(Direction.EAST);
                break;
            case Direction.SOUTH:
                orientation.setDirection(Direction.WEST);
                break;
            case Direction.WEST:
                orientation.setDirection(Direction.NORTH);
                break;
            case Direction.EAST:
                orientation.setDirection(Direction.SOUTH);
                break;
        }
    }

    private void moveLeft() {
        switch (orientation.getDirection()) {
            case Direction.NORTH:
                orientation.setDirection(Direction.WEST);
                break;
            case Direction.SOUTH:
                orientation.setDirection(Direction.EAST);
                break;
            case Direction.WEST:
                orientation.setDirection(Direction.SOUTH);
                break;
            case Direction.EAST:
                orientation.setDirection(Direction.NORTH);
                break;
        }
    }

    private void moveBackward() {
        switch (orientation.getDirection()) {
            case Direction.NORTH:
                coordinate.setY(coordinate.getY() - 1);
                break;
            case Direction.SOUTH:
                coordinate.setY(coordinate.getY() + 1);
                break;
            case Direction.WEST:
                coordinate.setX(coordinate.getX() + 1);
                break;
            case Direction.EAST:
                coordinate.setX(coordinate.getX() - 1);
                break;
        }
    }

    private void moveForward() {
        switch (orientation.getDirection()) {
            case Direction.NORTH:
                coordinate.setY(coordinate.getY() + 1);
                break; 
            case Direction.SOUTH:
                coordinate.setY(coordinate.getY() - 1);
                break;
            case Direction.WEST:
                coordinate.setX(coordinate.getX() - 1);
                break;
            case Direction.EAST:
                coordinate.setX(coordinate.getX() + 1);
                break;
        }
    }

}
