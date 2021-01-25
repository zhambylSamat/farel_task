package decathlon;

import java.util.HashMap;

public class Player {

    private String first_name;
    private String last_name;
    private Score score;
    private Integer total_score;
    private String position;

    public Player(String first_name, String last_name, Score score) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.score = score;
        total_score = calculateTotalScore(score);
    }

    private int calculateTotalScore(Score score) {
        int match_score = 0;
        match_score += calculateMatchScore(score.getM_100(), Constants.M_100);
        match_score += calculateMatchScore(score.getLong_jump(), Constants.LONG_JUMP);
        match_score += calculateMatchScore(score.getShot_put(), Constants.SHOT_PUT);
        match_score += calculateMatchScore(score.getHigh_jump(), Constants.HIGH_JUMP);
        match_score += calculateMatchScore(score.getM_400(), Constants.M_400);
        match_score += calculateMatchScore(score.getHurdles_110m(), Constants.HURDLES_100M);
        match_score += calculateMatchScore(score.getDiscus_throw(), Constants.DISCUS_THROW);
        match_score += calculateMatchScore(score.getPole_vault(), Constants.POLE_VAULT);
        match_score += calculateMatchScore(score.getJavelin_throw(), Constants.JAVELIN_THROW);
        match_score += calculateMatchScore(score.getM_1500(), Constants.M_1500);
        return match_score;
    }

    private int calculateMatchScore(double x, HashMap<String, Double> points) {
        return (int) (points.get("A") * Math.pow(Math.abs(points.get("B") - x), points.get("C")));
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Score getScore() {
        return this.score;
    }

    public void setTotal_score(Integer total_score) {
        this.total_score = total_score;
    }

    public Integer getTotal_score() {
        return this.total_score;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }
}
