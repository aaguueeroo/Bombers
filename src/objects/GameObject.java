package objects;

import gui.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    Coordinates coordinates;
    Size size;
//    BufferedImage sprite;
    int speed;

    public void init() {
        double coordX = Math.random() * (gui.Panel.WIDTH - size.x * 2);
        double coordY = Math.random() * (Panel.HEIGHT - size.y * 2);
        coordinates = new Coordinates(coordX, coordY, size.x, size.y);
    }

    public abstract void draw(Graphics graphics);

    public boolean isColliding(GameObject other) {
        double distanceX = this.coordinates.center_x - other.coordinates.center_x;
        double distanceY = this.coordinates.center_y - other.coordinates.center_y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < (size.x / 2 + other.size.x / 2);
    }

}
