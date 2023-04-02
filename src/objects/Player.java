package objects;

import gui.Panel;
import input_output.KeyHandler;

import java.awt.*;

public class Player extends GameObject implements Movable {

    private static final int SPEED = 500;

    KeyHandler keyHandler;
    Direction directionMovement;
    double radius;

    public Player(KeyHandler keyHandler) {
        super();
        size = new Size(50, 50);
        radius = size.x / 2;
        speed = SPEED;
        this.keyHandler = keyHandler;
        init();
    }

    @Override
    public void init() {
        coordinates = new Coordinates(Panel.WIDTH/2 - radius , Panel.HEIGHT / 2 - radius, size.x, size.y);
    }

    public void setDirectionMovement(Direction directionMovement) {
        this.directionMovement = directionMovement;
    }

    public void stopMovement() {
        speed = 0;
    }

    public void continueMovement() {
        speed = SPEED;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);

        graphics.fillOval((int) coordinates.topLeftCorner_x, (int) coordinates.topLeftCorner_y, (int) size.x, (int) size.y);

        //Checks if player is partially off the horizontal side of the screen
        if (coordinates.topLeftCorner_x > Panel.WIDTH - size.x) {
            int sizeLeft = (int) (coordinates.bottomRightCorner_x - Panel.WIDTH);
            graphics.fillOval((int) -(size.x - sizeLeft), (int) coordinates.topLeftCorner_y, (int) size.x, (int) size.y);
        }

        //Checks if player is partially off the vertical side of the screen
        if(coordinates.topLeftCorner_y > Panel.HEIGHT - size.y){
            int sizeLeft = (int) (coordinates.bottomRightCorner_y - Panel.HEIGHT);
            graphics.fillOval((int)coordinates.topLeftCorner_x, (int) -(size.y-sizeLeft), (int) size.x, (int) size.y);
        }

        //Checks if player is partially off the horizontal and vertical side of the screen
        if (coordinates.topLeftCorner_x > Panel.WIDTH - size.x && coordinates.topLeftCorner_y > Panel.HEIGHT - size.y) {
            int sizeLeftX = (int) (coordinates.bottomRightCorner_x - Panel.WIDTH);
            int sizeLeftY = (int) (coordinates.bottomRightCorner_y - Panel.HEIGHT);
            graphics.fillOval((int) -(size.x - sizeLeftX), (int) -(size.y - sizeLeftY), (int) size.x, (int) size.y);
        }
    }

    @Override
    public void move(double diffSeconds) {

        if (directionMovement != null) {
            switch (directionMovement) {
                case UP -> coordinates.moveY(-speed * diffSeconds);
                case DOWN -> coordinates.moveY(speed * diffSeconds);
                case LEFT -> coordinates.moveX(-speed * diffSeconds);
                case RIGHT -> coordinates.moveX(speed * diffSeconds);
            }
        }
    }
}
