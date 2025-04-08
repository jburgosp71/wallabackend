package main.java;

import java.util.Scanner;

public class MarsRover {
    static int sizex, sizey;
    static int roverx, rovery;
    static String roverz;
    static Surface surface;
    static Coordinate coordinate;
    static Direction direction;
    static Rover rover;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        sizex = reader.nextInt();
        System.out.println("Insert vertical map size:");
        sizey = reader.nextInt();


        System.out.println("Insert horizontal initial rover position:");
        roverx = reader.nextInt();
        System.out.println("Insert vertical initial rover position:");
        rovery = reader.nextInt();

        System.out.println("Insert initial rover direction (n = north, e = east, w = west, s = south):");
        roverz = reader.next();

        initializeRover(sizex, sizey, roverx, rovery, roverz);

        String command;
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right, x = Finish):");
            command = reader.next();

            rover.move(command);

            System.out.printf("Rover is at x:%d y:%d facing:%s%n",
                    rover.getCoordinate().getX(),
                    rover.getCoordinate().getY(),
                    rover.getOrientation().getDirection()
            );
        } while (!command.equals("x"));
    }

    public static void initializeRover(int sizeX, int sizeY, int roverX, int roverY, String orientation) {
        surface = new Surface(sizeX, sizeY);
        coordinate = new Coordinate(roverX, roverY);
        direction = new Direction(orientation);
        rover = new Rover(surface, coordinate, direction);
    }

    public static int getSurfaceMaxX() {
        return surface.getMaxX();
    }

    public static int getSurfaceMaxY() {
        return surface.getMaxY();
    }

    public static int getCoordinateX() {
        return coordinate.getX();
    }

    public static int getCoordinateY() {
        return coordinate.getY();
    }

    public static String getDirection() {
        return direction.getDirection();
    }

    public static void executeCommand(String command) {
        rover.move(command);
    }
}
