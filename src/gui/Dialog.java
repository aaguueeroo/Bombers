package gui;

import objects.Coordinates;
import objects.Size;

import java.awt.*;

public class Dialog extends UIObject {

    protected String title;
    protected String text;
    protected Button[] actions;

    public Dialog(String title) {
        super();
        this.text = text;
    }

    public Dialog(String title, String text, Size size) {
        super();
        this.title = title;
        this.text = text;
        this.size = size;

        double coordX = (Panel.WIDTH - size.x) / 2;
        double coordY = (Panel.HEIGHT - size.y) / 2;
        this.coordinates = new Coordinates(coordX, coordY, size.x, size.y);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Courier New", Font.BOLD, 40));
        graphics.drawString(title,
                370,
                200);
        drawStringMultiLine(graphics,
                text,
                (int) 370,
                (int) 400,
                (int) 400);
    }

    protected void drawStringMultiLine(Graphics g, String text, int x, int y, int maxWidth) {
        FontMetrics fm = g.getFontMetrics();

        String[] words = text.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (fm.stringWidth(sb + word) < maxWidth) {
                sb.append(" ").append(word);
            } else {
                g.drawString(sb.toString(), x, y);
                sb = new StringBuilder(word);
                y += fm.getHeight();
            }
        }
        g.drawString(sb.toString(), x, y);
    }
}
