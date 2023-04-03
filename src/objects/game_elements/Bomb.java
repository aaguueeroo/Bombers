package objects.game_elements;

import objects.Size;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Bomb extends A_GameObject {

    public Bomb() {
        super();
        size = new Size(20, 20);
        init();
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.green);

        AffineTransform oldTransform = g2d.getTransform(); // save old transform

        g2d.translate(coordinates.topLeftCorner_x + size.x / 2, coordinates.topLeftCorner_y + size.y / 2); // translate to center of square
        g2d.rotate(Math.PI / 4); // rotate by angle
        g2d.fillRect((int) (-size.x / 2), (int) (-size.y / 2), (int) size.x, (int) size.y); // draw square centered at (0, 0)

        g2d.setTransform(oldTransform); // restore old transform

    }
}
