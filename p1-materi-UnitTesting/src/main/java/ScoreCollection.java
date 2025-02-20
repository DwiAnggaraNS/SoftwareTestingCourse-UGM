import java.util.ArrayList;

public class ScoreCollection {
    public ArrayList<Integer> scores;

    public ScoreCollection() {
        scores = new ArrayList<Integer>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public double averageScore() {
        double Total = 0;

        for (int i=1; i<this.scores.size(); i++) {
            Total += this.scores.get(i);
        }

        return Total / this.scores.size();
    }
}
