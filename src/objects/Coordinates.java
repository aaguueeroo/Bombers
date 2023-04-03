package objects;

import gui.window.A_Panel;

public class Coordinates {
    public double topLeftCorner_x;
    public double topLeftCorner_y;
    public double bottomRightCorner_x;
    public double bottomRightCorner_y;
    public double center_x;
    public double center_y;

    private final double radius_X;
    private final double radius_Y;

    public Coordinates(double x, double y, double objectSize_x, double objectSize_y) {
        topLeftCorner_x = x;
        topLeftCorner_y = y;

        radius_X = objectSize_x / 2;
        radius_Y = objectSize_y / 2;

        adjustToTopLeftCorner();
    }

    private void adjustToTopLeftCorner(){
        bottomRightCorner_x = topLeftCorner_x + radius_X * 2;
        bottomRightCorner_y = topLeftCorner_y + radius_Y * 2;

        center_x = topLeftCorner_x + radius_X;
        center_y = topLeftCorner_y + radius_Y;
    }

    public void moveX(double amount){
        topLeftCorner_x += amount;

        if (topLeftCorner_x > A_Panel.WIDTH) {
            topLeftCorner_x = 0;
        }
        else if(topLeftCorner_x < 0) {
            topLeftCorner_x = A_Panel.WIDTH;
        }

        adjustToTopLeftCorner();
    }

    public void moveY(double amount){
        topLeftCorner_y += amount;

        if (topLeftCorner_y > A_Panel.HEIGHT) {
            topLeftCorner_y = 0;
        }
        else if(topLeftCorner_y < 0) {
            topLeftCorner_y = A_Panel.HEIGHT;
        }

        adjustToTopLeftCorner();
    }
}
