package objects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Statistics {
    private static final int MAX_BOMBS = 5;

    private int level;
    private int score;
    private int maxScore;
    private int bombsAccumulated;
    private SimpleTimer timer;

    private int obstaclesOnScreen;
    private int maxObstaclesOnScreen;
    private int obstaclesDestroyed;
    private int maxObstaclesDestroyed;
    private int coinsCollected;
    private int maxCoinsCollected;
    private int bombsCollected;
    private int maxBombsCollected;
    private int bombsExploded;
    private int maxBombsExploded;
    private int teleports;
    private int maxTeleports;

    public Statistics() {
        timer = new SimpleTimer();
        restartTimer();
        reset();
        this.maxScore = 0;

        this.maxObstaclesOnScreen = 0;
        this.maxObstaclesDestroyed = 0;
        this.maxCoinsCollected = 0;
        this.maxBombsCollected = 0;
        this.maxBombsExploded = 0;
        this.maxTeleports = 0;
    }

    public void reset(){
        this.level = 1;
        this.score = 0;
        this.bombsAccumulated = 0;
        this.obstaclesOnScreen = 0;
        this.obstaclesDestroyed = 0;
        this.coinsCollected = 0;
        this.bombsCollected = 0;
        this.bombsExploded = 0;
        this.teleports = 0;
        timer.restart();
    }

    //Level
    public int getLevel() {
        return this.level;
    }

    public void increaseLevel() {
        this.level++;
    }

    //Score
    public int getScore() {
        return this.score;
    }

    public void increaseScore(int n) {
        this.score += n;

        if (this.score > this.maxScore) {
            this.maxScore = this.score;
        }
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    //Bombs accumulated
    public int getBombsAccumulated() {
        return this.bombsAccumulated;
    }

    public void increaseBombsAccumulated() {
        this.bombsAccumulated++;

        if (this.bombsAccumulated > MAX_BOMBS) {
            this.bombsAccumulated = MAX_BOMBS;
        }

        increaseBombsCollected();
    }

    public void reduceBombsAccumulated() {
        this.bombsAccumulated--;

        if (this.bombsAccumulated < 0) {
            this.bombsAccumulated = 0;
        }

        increaseBombsUsed();
        increaseObstaclesDestroyed();
    }

    //Times

    public void updateTimer() {
        timer.update();
    }

    public void restartTimer() {
        timer.restart();
    }

    public void pauseTimer() {
        timer.pause();
    }

    public String getTimeString() {
        return timer.toString();
    }

    //Obstacles
    public int getObstaclesOnScreen() {
        return this.obstaclesOnScreen;
    }

    public void setObstaclesOnScreen(int n) {
        this.obstaclesOnScreen = n;
        if(this.obstaclesOnScreen > this.maxObstaclesOnScreen) {
            this.maxObstaclesOnScreen = this.obstaclesOnScreen;
        }
    }

    public int getMaxObstaclesOnScreen() {
        return this.maxObstaclesOnScreen;
    }

    public int getObstaclesDestroyed() {
        return this.obstaclesDestroyed;
    }

    public void increaseObstaclesDestroyed() {
        this.obstaclesDestroyed++;
        if(this.obstaclesDestroyed > this.maxObstaclesDestroyed) {
            this.maxObstaclesDestroyed = this.obstaclesDestroyed;
        }
    }

    public int getMaxObstaclesDestroyed() {
        return this.maxObstaclesDestroyed;
    }

    //Coins
    public int getCoinsCollected() {
        return this.coinsCollected;
    }

    public void increaseCoinsCollected() {
        this.coinsCollected++;
        if(this.coinsCollected > this.maxCoinsCollected) {
            this.maxCoinsCollected = this.coinsCollected;
        }
    }

    public int getMaxCoinsCollected() {
        return this.maxCoinsCollected;
    }

    //Bombs
    public int getBombsCollected() {
        return this.bombsCollected;
    }

    public void increaseBombsCollected() {
        this.bombsCollected++;
        if(this.bombsCollected > this.maxBombsCollected) {
            this.maxBombsCollected = this.bombsCollected;
        }
    }

    public int getMaxBombsCollected() {
        return this.maxBombsCollected;
    }

    public int getBombsExploded() {
        return this.bombsExploded;
    }

    public void increaseBombsUsed() {
        this.bombsExploded++;
        if(this.bombsExploded > this.maxBombsExploded) {
            this.maxBombsExploded = this.bombsExploded;
        }
    }

    public int getMaxBombsExploded() {
        return this.maxBombsExploded;
    }

    //Teleports
    public int getTeleports() {
        return this.teleports;
    }

    public void increaseTeleports() {
        this.teleports++;
        if(this.teleports > this.maxTeleports) {
            this.maxTeleports = this.teleports;
        }
    }

    public int getMaxTeleports() {
        return this.maxTeleports;
    }

    @Override
    public String toString() {
        String str;

        str = "Level: " + this.level;
        str += "\nScore: " + this.score;
        str += "\nTime: " + timer.toString();
        str += "\nMax Score: " + this.maxScore;
        str += "\nBombs accumulated: " + this.bombsAccumulated;

        return str;
    }
}
