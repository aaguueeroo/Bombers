import gui.GamePanel;
import gui.Panel;
import input_output.KeyHandler;
import input_output.Keys;
import objects.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for the gameplay screen. It contains the game loop.
 */
public class Gameplay {

    private static final int INITIAL_OBSTACLES = 5;

    final GamePanel panel;
    final KeyHandler keyHandler;
    final StateManager stateManager;

    Player player;
    Coin coin;
    List<Obstacle> obstacles;
    Teleporter teleporter;
    Statistics statistics;

    int level;
    int bombs;
    long startTime;

    //Constructor
    public Gameplay(Panel panel, KeyHandler keyHandler, StateManager stateManager) {
        this.panel = (GamePanel) panel;
        this.keyHandler = keyHandler;
        this.stateManager = stateManager;
    }

    //Methods
    public void init() {
        player = new Player(keyHandler);
        level = 1;
        bombs = 0;
        coin = new Coin();
        initObstacles();
        statistics = new Statistics();

        startTime = System.currentTimeMillis();
        stateManager.setState(GameStates.RUNNING);
    }


    private void initTeleporter() {
        boolean randomBoolean = Math.random() < 0.5;
        if (randomBoolean) {
            teleporter = new Teleporter();
        } else {
            teleporter = null;
        }
    }

    private void initObstacles() {
        obstacles = new ArrayList<>();
        for (int i = 0; i < INITIAL_OBSTACLES; i++) {
            obstacles.add(new Obstacle());
        }
    }

//    private void initObstacles(int n) {
//        obstacles = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            obstacles.add(new Obstacle());
//        }
//    }

    public void run() {

        long lastTick = System.currentTimeMillis();

        while (true) {

            long currentTick = System.currentTimeMillis();
            double diffSeconds = (currentTick - lastTick) / 1000.0;
            lastTick = currentTick;

            handleUserInput();
            update(diffSeconds);
            // get user input
            // do something with user input (update)
            panel.clear();
            draw();
            panel.redraw();
            System.out.flush();

        }

    }

    private void draw() {
        panel.draw(player);
        for (Obstacle obstacle : obstacles) {
            panel.draw(obstacle);
        }
        panel.draw(coin);
        if (teleporter != null) {
            panel.draw(teleporter);
        }
    }

    private void update(double diffSeconds) {

        player.move(diffSeconds);
        if (teleporter != null) {
            teleporter.move(diffSeconds);
        }
        checkCollisions();

        // update the game state
        // check if the game is over
        // check if the game is won
    }

    private void checkCollisions() {

        //Crash with obstacles
        for (int i = 0; i < obstacles.size(); i++) {
            if (player.isColliding(obstacles.get(i))) {
                if (bombs > 0) {
                    obstacles.remove(i);
                    bombs--;
                } else
                    gameOver();
            }
        }

        //Get coin
        if (player.isColliding(coin)) {
            level++;
            statistics.increaseScore(coin.getValue());
//            initTeleporter();
            addObstacles(2);
            initTeleporter();
            coin = new Coin();
        }

        //Teleport
        if (teleporter != null) {
            if (player.isColliding(teleporter)) {
                initTeleporter();
                coin = new Coin();

                for (int i = 0; i < 5; i++) {
                    obstacles.add(new Obstacle());
                }

                statistics.increaseScore(10);
            }
        }
    }

    /**
     * Adds a random number of obstacles to the screen based on the level of the player.
     */
    private void addObstacles(int limit) {
        int n = (int) (Math.random() * limit);

        for (int i = 0; i < n; i++) {
            obstacles.add(new Obstacle());
            if(obstacles.get(i).isColliding(player)){
                obstacles.remove(i);
            }
        }
    }


    private void pause() {
        //TODO: pause the game, not only the state but timer and so on
        player.stopMovement();
        if (teleporter != null)
            teleporter.stopMovement();
        stateManager.setState(GameStates.PAUSED);
    }

    private void resume() {
        player.continueMovement();
        if (teleporter != null)
            teleporter.continueMovement();
        stateManager.setState(GameStates.RUNNING);
    }

    private void gameOver() {
        player.stopMovement();
        if (teleporter != null)
            teleporter.stopMovement();
        stateManager.setState(GameStates.FINISHED);
    }

//    private void victory(){
//        player.stopMovement();
//        stateManager.setState(GameStates.FINISHED);
//    }

    private void handleUserInput() {
        Keys keyPressed = keyHandler.getKeyPressed();
        Keys keyReleased = keyHandler.getKeyReleased();

        if (keyReleased != null) {
            if (keyReleased == Keys.PAUSE) {
                if (stateManager.gameState == GameStates.RUNNING) {
                    keyHandler.resetKeyReleased();
                    pause();
                } else if (stateManager.gameState == GameStates.PAUSED) {
                    keyHandler.resetKeyReleased();
                    resume();
                    //TODO add direction so the player continues moving
                }
            }

            if (keyReleased == Keys.SHOOT && stateManager.gameState == GameStates.FINISHED) {
                keyHandler.resetKeyReleased();
                init();
            }
        }

        if (stateManager.gameState == GameStates.PAUSED) {
            return;
        }

        switch (keyPressed) {
            case UP:
                player.setDirectionMovement(Direction.UP);
                break;
            case DOWN:
                player.setDirectionMovement(Direction.DOWN);
                break;
            case LEFT:
                player.setDirectionMovement(Direction.LEFT);
                break;
            case RIGHT:
                player.setDirectionMovement(Direction.RIGHT);
                break;
            case SHOOT:
                break;
        }
    }


}
