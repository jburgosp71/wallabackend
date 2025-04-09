package main.java.domain.model;

public record Surface(int maxX, int maxY) {

    public Coordinate wrap(Coordinate coordinate) {
        int x = ((coordinate.getX() % (maxX + 1)) + (maxX + 1)) % (maxX + 1);
        int y = ((coordinate.getY() % (maxY + 1)) + (maxY + 1)) % (maxY + 1);
        return new Coordinate(x, y);
    }
}
