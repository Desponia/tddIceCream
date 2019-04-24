package com.example.tdd;

import java.util.Objects;

public class Score {
    private int balls;
    private int strikes;

    public Score(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    @Override
    public String toString() {
        return "Score{" +
                "balls=" + balls +
                ", strikes=" + strikes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return balls == score.balls &&
                strikes == score.strikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, strikes);
    }

    public int balls() {
        return this.balls;
    }

    public int strikes() {
        return this.strikes;
    }
}
