package gui;

import gui.components.Dialog;
import objects.Size;
import objects.Statistics;

import java.awt.*;

public class EndDialog extends Dialog {

    Statistics statistics;

    public EndDialog(String title, String text) {
        super(title, text, new Size(400, 600));
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

}
