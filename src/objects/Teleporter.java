package objects;

import java.awt.*;

public class Teleporter extends GameObject implements Movable {

    private static final int SPEED = 100;
    private static final int SIZE = 70;

    Direction directionMovement;

    public Teleporter() {
        super();
        speed = SPEED;
        size = new Size(SIZE, SIZE);
        setDirectionMovement();
        init();
    }

    public void setDirectionMovement() {
        double random = Math.random() * 100;

        if (random >= 0 && random < 25) {
            this.directionMovement = Direction.UP;
        } else if (random >= 25 && random < 50) {
            this.directionMovement = Direction.DOWN;
        } else if (random >= 50 && random < 75) {
            this.directionMovement = Direction.LEFT;
        } else if (random >= 75 && random < 100) {
            this.directionMovement = Direction.RIGHT;
        }
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect((int) coordinates.topLeftCorner_x, (int) coordinates.topLeftCorner_y, (int) size.x, (int) size.y);
    }

    @Override
    public void move(double diffSeconds) {

        switch (directionMovement) {
            case UP -> coordinates.moveY(speed * diffSeconds);
            case DOWN -> coordinates.moveY(-speed * diffSeconds);
            case LEFT -> coordinates.moveX(-speed * diffSeconds);
            case RIGHT -> coordinates.moveX(speed * diffSeconds);
        }

    }

    @Override
    public void stopMovement() {
        speed = 0;
    }

    @Override
    public void continueMovement() {
        speed = SPEED;
    }
}
