package com.example.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    void name() {

    }

    @Test
    void create() {
        new Game(1, 2, 3);
    }

    @Test
    void badParamCount() {
        Game game = new Game(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 2));
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 2, 3, 4));
    }

    @Test
    void badNumberRange() {
        Game game = new Game(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> game.guess(-1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(10, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, -1, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 10, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 2, -1));
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 2, 10));
    }

    @Test
    void noMatch() {
        Game game = new Game(1, 2, 3);
        Score s = game.guess(4, 5, 6);

//        assertEquals(0, s.balls());
//        assertEquals(0, s.strikes());
        assertScore(s, new Score(0, 0));
    }

    @Test
    void match_1S() {
        Game game = new Game(1, 2, 3);
        Score s = game.guess(1, 4, 5);
//        assertEquals(0, s.balls());
//        assertEquals(1, s.strikes());
        assertScore(s, new Score(0, 1));

        Game game2 = new Game(9, 2, 3);
        Score s2 = game2.guess(9, 4, 5);
        Score expected = new Score(0, 1);
        assertScore(s2, expected);
//        assertEquals(0, s2.balls());
//        assertEquals(1, s2.strikes());

        Score s3 = game2.guess(4, 2, 3);
        assertEquals(0, s3.balls());
        assertEquals(2, s3.strikes());
        Score s4 = game2.guess(4, 5, 3);
        assertEquals(0, s4.balls());
        assertEquals(1, s4.strikes());
    }

    @Test
    void match_2() {
        Game game = new Game(1, 2, 3);
        assertEquals(game.guess(1, 2, 5), new Score(0, 2));
    }

    @Test
    void match_3() {
        Game game = new Game(1, 2, 3);
        assertEquals(game.guess(1, 2, 3), new Score(0, 3));
    }

    // 한개 값이 다른 자리로 일치하는 경우
    @Test
    void match_1B() {
        Game game = new Game(1, 2, 3);
        assertScore(game.guess(4, 1, 5), new Score(1, 0));
        assertScore(game.guess(4, 5, 1), new Score(1, 0));
        assertScore(game.guess(2, 5, 4), new Score(1, 0));
        assertScore(game.guess(4, 5, 2), new Score(1, 0));
        assertScore(game.guess(3, 5, 4), new Score(1, 0));
        assertScore(game.guess(4, 3, 5), new Score(1, 0));
    }

    @Test
    void match2B() {
        Game game = new Game(1, 2, 3);
        assertScore(game.guess(4, 1, 2), new Score(2, 0));
    }

    private void assertScore(Score s2, Score expected) {
        assertEquals(expected, s2);
    }
}
