package objects.game_elements;

import objects.Size;

import java.awt.*;

public class Obstacle extends A_GameObject {

    public Obstacle(){
        super();
        speed = 0;
        size = new Size(50, 50);
        init();
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fillRect((int) coordinates.topLeftCorner_x, (int) coordinates.topLeftCorner_y, (int) size.x, (int) size.y);
    }

}
