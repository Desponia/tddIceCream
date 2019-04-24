package com.example.tdd;

public class Game {
    private int[] nums;

    public Game(int... nums) {
        this.nums = nums;
    }


    public Score guess(int... g) {
        verifyLength(g);

        verifyNumberRange(g);

        return new Score(getBallCnt(g), getMatchCnt(g));
//        throw new IllegalArgumentException();
    }

    private void verifyNumberRange(int[] g) {
        if (g[0] < 0 || g[0] > 9 || g[1] < 0 || g[1] > 9 || g[2] < 0 || g[2] > 9)
            throw new IllegalArgumentException();
    }

    private void verifyLength(int ...g) {
        if (g.length != 3)
            throw new IllegalArgumentException();
    }

    private int getMatchCnt(int ...g) {
        int matchCnt = 0;
        boolean firstMatch = nums[0] == g[0];
        boolean secondMatch = nums[1] == g[1];
        boolean thirdMatch = nums[2] == g[2];
        if (firstMatch) matchCnt++;
        if (secondMatch) matchCnt++;
        if (thirdMatch) matchCnt++;
        return matchCnt;
    }

    private int getBallCnt(int ...g) {
        int ballCnt = 0;
        if (nums[0] == g[1] || nums[0] == g[2]) {
            ballCnt++;
        }

        if (nums[1] == g[0] || nums[1] == g[2]) {
            ballCnt++;
        }
        if (nums[2] == g[0] || nums[2] == g[1]) {
            ballCnt++;
        }
        return ballCnt;
    }
}
