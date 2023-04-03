package objects;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleTimer {

    private Timer timer;
    private long seconds;

    private long startTime;
//    private long pauseTime;
    private long elapsedTime;

    public SimpleTimer() {
        timer = new Timer();
    }

    public void start() {
        startTime = System.currentTimeMillis();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                seconds = (System.currentTimeMillis() - startTime) / 1000;
            }
        }, 1000, 1000);
    }

    public void update() {
        elapsedTime = (System.currentTimeMillis() - startTime);
    }

    public void pause() {
        timer.cancel();
//        pauseTime = System.currentTimeMillis();
//        elapsedTime = pauseTime - startTime;
    }

    public void restart() {
        timer = new Timer();
        seconds = 0;
        elapsedTime = 0;
        start();
    }

    public long getTimeElapsed() {
        return elapsedTime;
    }

    public String toString() {
        LocalTime time = LocalTime.ofSecondOfDay(elapsedTime / 1000);
        return time.format(DateTimeFormatter.ofPattern("mm:ss"));
    }

}
