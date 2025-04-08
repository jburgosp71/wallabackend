package main.java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int roverx, int rovery) {
        x = roverx;
        y = rovery;
    }
}
