package main.java.domain.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Surface {
    private final int maxX;
    private final int maxY;
    private final List<Coordinate> obstacles;

    public Surface(int maxX, int maxY) {
        this(maxX, maxY, List.of());
    }

    public Surface(int maxX, int maxY, List<Coordinate> obstacles) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.obstacles = obstacles;
    }

    public Coordinate wrap(Coordinate coordinate) {
        int x = ((coordinate.getX() % (maxX + 1)) + (maxX + 1)) % (maxX + 1);
        int y = ((coordinate.getY() % (maxY + 1)) + (maxY + 1)) % (maxY + 1);
        return new Coordinate(x, y);
    }

    public boolean hasObstacle(Coordinate coordinate) {
        return obstacles.contains(coordinate);
    }

}
