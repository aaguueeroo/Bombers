package gui.window;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    //Dimensions of the window
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    private A_Panel panel;

    public Frame(String title) {
        // Set window properties
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        // Set window to be visible
        setVisible(true);
    }

//    public Panel getPanel() {
//        return panel;
//    }

    public void setPanel(A_Panel panel) {
        if (this.panel != null) {
            remove(this.panel);
        }
        this.panel = panel;
        this.add(panel, BorderLayout.SOUTH);
    }


}
