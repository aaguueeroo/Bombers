package objects;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Coin extends GameObject {

    int value;

    public Coin() {
        super();
        value = 1;
        size = new Size(20, 20);
        init();
    }

    public int getValue() {
        return value;
    }

    /**
     * Draws a rotated square
     */
    public void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.yellow);

        AffineTransform oldTransform = g2d.getTransform(); // save old transform

        g2d.translate(coordinates.topLeftCorner_x + size.x / 2, coordinates.topLeftCorner_y + size.y / 2); // translate to center of square
        g2d.rotate(Math.PI / 4); // rotate by angle
        g2d.fillRect((int) (-size.x / 2), (int) (-size.y / 2), (int) size.x, (int) size.y); // draw square centered at (0, 0)

        g2d.setTransform(oldTransform); // restore old transform
    }
}
