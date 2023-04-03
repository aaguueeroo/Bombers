package input_output;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private Keys keyPressed;
    private Keys keyReleased;

    public KeyHandler(){
        keyPressed = Keys.NONE;
    }

    public Keys getKeyPressed() {
        if (keyPressed == null) {
            return Keys.NONE;
        }
        return keyPressed;
    }

    public Keys getKeyReleased() {
        if (keyReleased == null) {
            return Keys.NONE;
        }
        return keyReleased;
    }

    public void resetKeyReleased() {
        keyReleased = Keys.NONE;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        this.keyPressed = intToKey(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keyReleased = intToKey(key);
    }

    public Keys intToKey(int n) {

        switch (n) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                keyPressed = Keys.UP;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                keyPressed = Keys.DOWN;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                keyPressed = Keys.LEFT;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                keyPressed = Keys.RIGHT;
                break;
            case KeyEvent.VK_SPACE:
                keyPressed = Keys.SHOOT;
                break;
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_P:
                keyPressed = Keys.PAUSE;
                break;
        }

        return keyPressed;
    }

}
