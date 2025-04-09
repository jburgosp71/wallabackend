package main.java.domain.model;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH("n"), EAST("e"), SOUTH("s"), WEST("w");

    private final String shortCode;

    Direction(String shortCode) {
        this.shortCode = shortCode;
    }

    public Direction moveLeft() {
        return values()[(ordinal() + 3) % 4];
    }

    public static Direction fromShortCode(String code) {
        for (Direction direction : values()) {
            if (direction.getShortCode().equalsIgnoreCase(code)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Invalid direction code: " + code);
    }

    public Direction moveRight() {
        return values()[(ordinal() + 1) % 4];
    }

    public Coordinate moveForward(Coordinate current) {
        return switch (this) {
            case NORTH -> current.move(0, 1);
            case EAST  -> current.move(1, 0);
            case SOUTH -> current.move(0, -1);
            case WEST  -> current.move(-1, 0);
        };
    }

    public Coordinate moveBackward(Coordinate current) {
        return switch (this) {
            case NORTH -> current.move(0, -1);
            case EAST  -> current.move(-1, 0);
            case SOUTH -> current.move(0, 1);
            case WEST  -> current.move(1, 0);
        };
    }
}
