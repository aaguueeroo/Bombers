package gui;

import objects.GameObject;

/**
 * Contains the methods to draw the graphics of the main gameplay.
 */
public class GamePanel extends Panel {

    public GamePanel() {
        super();
    }

    public void draw(GameObject object) {
        object.draw(graphics);
    }

}


