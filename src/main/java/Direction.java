package main.java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Direction {
    public static final String NORTH = "n";
    public static final String SOUTH = "s";
    public static final String WEST = "w";
    public static final String EAST = "e";

    String direction;

    public Direction(String direction) {
        this.direction = direction;
    }
}
