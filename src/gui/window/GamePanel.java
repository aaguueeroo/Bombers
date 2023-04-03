package gui.window;

import gui.components.A_UIObject;
import objects.game_elements.A_GameObject;

/**
 * Contains the methods to draw the graphics of the main gameplay.
 */
public class GamePanel extends A_Panel {

    public GamePanel() {
        super();
    }

    public void draw(A_GameObject object) {
        object.draw(graphics);
    }

    public void draw(A_UIObject object) {
        object.draw(graphics);
    }

}


