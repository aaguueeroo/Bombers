package gui;

import objects.Coordinates;
import objects.Size;
import themes.Colors;

import java.awt.*;

public abstract class UIObject {

    Coordinates coordinates;
    Size size;

    //Appearance
    public double paddingX;
    public double paddingY;
    public Color borderColor;
    public int borderSize;
    public Color backgroundColor;
    public Color contentColor;
    public int borderRadius;


    /**
     * Default constructor witht the appearance of dialogs at the bottom of the screen.
     */
    public UIObject() {

        this.paddingX = 200;
        this.paddingY = 400;
        this.borderColor = Color.white;
        this.borderSize = 7;
        this.backgroundColor = Color.BLACK;
        this.contentColor = Color.white;
        this.borderRadius = 25;

        double sizeX = Panel.WIDTH - 2 * paddingX;
        double sizeY = Panel.HEIGHT - 2 * paddingY;
        this.size = new Size(sizeX, sizeY);

        double topLeftCorner_x = paddingX;
        double topLeftCorner_y = Panel.HEIGHT - sizeY - paddingY;
        this.coordinates = new Coordinates(topLeftCorner_x,
                topLeftCorner_y,
                sizeX,
                sizeY);

    }

    /**
     * Constructor for creation of GUIObjects that don't
     * use the default appearance.
     */
    public UIObject(double x,
                    double y,
                    int sizeX,
                    int sizeY,
                    int paddingX,
                    int paddingY,
                    Color borderColor,
                    int borderSize,
                    Color backgroundColor,
                    Color contentColor,
                    int borderRadius) {

        this.coordinates = new Coordinates(x, y, sizeX, sizeY);
        this.size = new Size(sizeX, sizeY);
        this.paddingX = paddingX;
        this.paddingY = paddingY;
        this.borderColor = borderColor;
        this.borderSize = borderSize;
        this.backgroundColor = backgroundColor;
        this.contentColor = contentColor;
        this.borderRadius = borderRadius;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRoundRect(
                (int) coordinates.topLeftCorner_x,
                (int) coordinates.topLeftCorner_y,
                (int) size.x,
                (int) size.y,
                borderRadius,
                borderRadius);
        graphics.setColor(backgroundColor);
        graphics.fillRoundRect(
                (int) coordinates.topLeftCorner_x + borderSize / 2,
                (int) coordinates.topLeftCorner_y + borderSize / 2,
                (int) size.x - borderSize,
                (int) size.y - borderSize,
                borderRadius,
                borderRadius);

    }
}
