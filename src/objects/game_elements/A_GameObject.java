package objects.game_elements;

import gui.window.A_Panel;
import objects.Coordinates;
import objects.Size;

import java.awt.*;

public abstract class A_GameObject {

    Coordinates coordinates;
    Size size;
//    BufferedImage sprite;
    int speed;

    public void init() {
        double coordX = Math.random() * (A_Panel.WIDTH - size.x * 2);
        double coordY = Math.random() * (A_Panel.HEIGHT - size.y * 2);
        coordinates = new Coordinates(coordX, coordY, size.x, size.y);
    }

    public abstract void draw(Graphics graphics);

    public boolean isColliding(A_GameObject other) {
        double distanceX = this.coordinates.center_x - other.coordinates.center_x;
        double distanceY = this.coordinates.center_y - other.coordinates.center_y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < (size.x / 2 + other.size.x / 2);
    }

    public boolean isInRadius(A_GameObject other, double actionRadius) {
        double distanceX = this.coordinates.center_x - other.coordinates.center_x;
        double distanceY = this.coordinates.center_y - other.coordinates.center_y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < (size.x / 2 + other.size.x / 2 + actionRadius);
    }

}
