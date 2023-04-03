package objects.game_elements;

import objects.Coordinates;
import objects.Size;

import java.awt.*;

public class Bomb extends A_GameObject {

    public static final int BOMB_RADIUS = 30;
    private static final double TIME_TO_EXPLODE_MILIS = 1000;
    boolean isExploding = false;
    long timeExploded;

    public Bomb(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.size = new Size(BOMB_RADIUS, BOMB_RADIUS);
    }

    @Override
    public void draw(Graphics graphics) {
        //draws a black circle with radious 30
        graphics.setColor(Color.BLACK);
        graphics.fillOval((int) coordinates.topLeftCorner_x, (int) coordinates.topLeftCorner_y, (int) size.x, (int) size.y);
    }

    public void fire(double diffSeconds) {
        //TODO: make the bomb explode

        timeExploded = System.currentTimeMillis();
        isExploding = true;

        if (System.currentTimeMillis() > timeExploded + TIME_TO_EXPLODE_MILIS) {
            isExploding = false;
            size.x += diffSeconds * 30;
            size.y += diffSeconds * 30;
        }
    }
}
