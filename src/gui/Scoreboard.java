package gui;

import gui.components.A_UIObject;
import gui.window.A_Panel;
import objects.Statistics;

import java.awt.*;

public class Scoreboard extends A_UIObject {

    Statistics stats;

    public Scoreboard(Statistics stats) {
        super();
        this.stats = stats;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Courier New", Font.BOLD, 40));
        graphics.drawString("Score: " + stats.getScore(), 10, 50);
        graphics.drawString("Max Score: " + stats.getMaxScore(), 10, 100);
        graphics.drawString("Level: " + stats.getLevel(), 10, 150);
        graphics.drawString("Time: " + stats.getTimeString(), A_Panel.WIDTH - 280, 50);
        graphics.drawString("Bombs: " + stats.getBombsAccumulated(), A_Panel.WIDTH - 280, 100);
    }
}
