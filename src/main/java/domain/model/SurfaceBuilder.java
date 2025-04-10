package main.java.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SurfaceBuilder {
    private final int maxX;
    private final int maxY;
    private final List<Coordinate> obstacles = new ArrayList<>();

    public SurfaceBuilder(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public SurfaceBuilder addObstacle(Coordinate obstacle) {
        obstacles.add(obstacle);
        return this;
    }

    public Surface build() {
        return new Surface(maxX, maxY, Collections.unmodifiableList(obstacles));
    }
}
