package main.java;

import java.util.Scanner;

public class MarsRover {
    static int sizex, sizey;
    static int roverx, rovery;
    static String roverz;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        setSizeX(reader.nextInt());
        System.out.println("Insert vertical map size:");
        setSizeY(reader.nextInt());

        Surface marsSurface = new Surface(sizex, sizey);

        System.out.println("Insert horizontal initial rover position:");
        setRoverX(reader.nextInt());
        System.out.println("Insert vertical initial rover position:");
        setRoverY(reader.nextInt());

        Coordinate coordinate = new Coordinate(roverx, rovery);

        System.out.println("Insert initial rover direction (n = north, e = east, w = west, s = south):");
        setRoverZ(reader.next());



        String command = "";
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right, x = Finish):");
            command = reader.next();

            executeCommand(command);

            System.out.printf("Rover is at x:%d y:%d facing:%s%n", roverx, rovery, roverz);
        } while (!command.equals("x"));
    }

    public static void setRoverX(int rx) {
        roverx = rx;
    }

    public static void setRoverY(int ry) {
        rovery = ry;
    }

    public static void setRoverZ(String rz) {
        roverz = rz;
    }

    public static void setSizeX(int sx) {
        sizex = sx;
    }

    public static void setSizeY(int sy) {
        sizey = sy;
    }

    public static int getSizeX() {
        return sizex;
    }

    public static int getSizeY() {
        return sizey;
    }

    public static int getRoverX() {
        return roverx;
    }

    public static int getRoverY() {
        return rovery;
    }

    public static String getRoverZ() {
        return roverz;
    }

    public static void executeCommand(String command) {
        if (command.equals("f")) {
            if (roverz.equals("n")) {
                rovery += 1;
            }
            if (roverz.equals("w")) {
                roverx -= 1;
            }
            if (roverz.equals("s")) {
                rovery -= 1;
            }
            if (roverz.equals("e")) {
                roverx += 1;
            }
        }
        if (command.equals("b")) {
            if (roverz.equals("n")) {
                rovery -= 1;
            }
            if (roverz.equals("w")) {
                roverx += 1;
            }
            if (roverz.equals("s")) {
                rovery += 1;
            }
            if (roverz.equals("e")) {
                roverx -= 1;
            }
        }
        if (command.equals("l")) {
            if (roverz.equals("n")) {
                roverz = "w";
            } else if (roverz.equals("w")) {
                roverz = "s";
            } else if (roverz.equals("s")) {
                roverz = "e";
            } else if (roverz.equals("e")) {
                roverz = "n";
            }
        }
        if (command.equals("r")) {
            if (roverz.equals("n")) {
                roverz = "e";
            }else if (roverz.equals("e")) {
                roverz = "s";
            } else if (roverz.equals("s")) {
                roverz = "w";
            } else if (roverz.equals("w")) {
                roverz = "n";
            }
        }
    }
}
