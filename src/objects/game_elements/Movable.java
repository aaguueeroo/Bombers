package objects.game_elements;

public interface Movable {

    void move(double diffSeconds);
    void stopMovement();

    void continueMovement();
}
