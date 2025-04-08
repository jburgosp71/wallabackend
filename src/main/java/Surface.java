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

    public boolean isOverMaxLimitX(int posX) {
        return posX > this.getMaxX();
    }

    public boolean isUnderMinLimitX(int posX) {
        return posX < this.getMinX();
    }

    public boolean isOverMaxLimitY(int posY) {
        return posY > this.getMaxY();
    }

    public boolean isUnderMinLimitY(int posY) {
        return posY < this.getMinX();
    }
}
