package main.java;

import lombok.Value;

@Value
public class Surface {
    public static final int ORIGIN = 0;

    int maxX;
    int minX;
    int maxY;
    int minY;

    public Surface(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = ORIGIN;
        this.minY = ORIGIN;
    }

    public boolean isMaxLimitX(int posX) {
        return posX >= this.getMaxX();
    }

    public boolean isMinLimitX(int posX) {
        return posX <= this.getMinX();
    }

    public boolean isMaxLimitY(int posY) {
        return posY >= this.getMaxY();
    }

    public boolean isMinLimitY(int posY) {
        return posY <= this.getMinX();
    }
}
