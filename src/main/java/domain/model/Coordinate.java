package main.java.domain.model;

import lombok.Value;

@Value
public class Coordinate {
    int x;
    int y;

    public Coordinate move(int deltaX, int deltaY) {
        return new Coordinate(x + deltaX, y + deltaY);
    }
}
