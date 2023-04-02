package gui;

import objects.Statistics;

import java.awt.*;

public class StatsPanel extends UIObject{

    Statistics stats;

    public StatsPanel(Statistics stats) {
        super();
        this.stats = stats;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Courier New", Font.BOLD, 40));
        graphics.drawString("Score: " + stats.getScore(), 10, 50);
        graphics.drawString("Max Score: " + stats.getMaxScore(), 10, 100);
        graphics.drawString("Level: " + stats.getLevel(), 10, 150);
        graphics.drawString("Bombs: " + stats.getBombsAccumulated(), Panel.WIDTH - 250, 50);
    }
}
