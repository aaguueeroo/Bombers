package gui.window;

import themes.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class A_Panel extends JPanel {

    public static final int WIDTH = gui.window.Frame.WIDTH;
    public static final int HEIGHT = Frame.HEIGHT - 28;

    //Output objects
    public Graphics graphics;
    final private BufferedImage imageBuffer;

    public A_Panel() {

        //Initiate panel variables
        this.setSize(WIDTH, HEIGHT);
        this.setBackground(Colors.window_background);

        //Initiate graphics system
        GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
        graphics = imageBuffer.getGraphics();
    }

    public void clear() {
        graphics.setColor(Colors.window_background);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void redraw() {
        this.getGraphics().drawImage(imageBuffer, 0, 0, this);
    }

}
