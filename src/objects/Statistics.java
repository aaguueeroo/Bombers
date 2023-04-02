package objects;

public class Statistics {

    private int score;
    private int maxScore;

    public Statistics() {
        this.maxScore = 0;
        this.score = 0;
    }

    public Statistics(int maxScore){
        this.maxScore = maxScore;
        this.score = 0;
    }

    public void increaseScore(int n) {
        this.score += n;

        if (this.score > this.maxScore) {
            this.maxScore = this.score;
        }
    }

    public int getScore() {
        return this.score;
    }

    public int getMaxScore() {
        return this.maxScore;
    }



}
