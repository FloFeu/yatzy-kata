import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(14, Yatzy.chance(1, 1, 3, 3, 6));
        assertEquals(21, Yatzy.chance(4, 5, 5, 6, 1));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.yatzy(1, 1, 1, 1, 1));
        assertEquals(0, Yatzy.yatzy(1, 1, 1, 2, 1));
    }

    @Test
    public void ones() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void threes() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void pair() {
        assertEquals(0, Yatzy.pair(1, 2, 3, 4, 5));
        assertEquals(8, Yatzy.pair(3, 3, 3, 4, 4));
        assertEquals(12, Yatzy.pair(1, 1, 6, 2, 6));
        assertEquals(6, Yatzy.pair(3, 3, 3, 4, 1));
        assertEquals(6, Yatzy.pair(3, 3, 3, 3, 1));
    }

    @Test
    public void twoPairs() {
        assertEquals(8, Yatzy.twoPairs(1, 1, 2, 3, 3));
        assertEquals(0, Yatzy.twoPairs(1, 1, 2, 3, 4));
        assertEquals(6, Yatzy.twoPairs(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.twoPairs(3, 3, 3, 3, 1));

    }

    @Test
    public void threeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(0, Yatzy.threeOfAKind(3, 3, 4, 5, 6));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 1));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(8, Yatzy.fourOfAKind(2, 2, 2, 2, 5));
        assertEquals(0, Yatzy.fourOfAKind(2, 2, 2, 5, 5));
        assertEquals(8, Yatzy.fourOfAKind(2, 2, 2, 2, 2));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        assertEquals(8, Yatzy.fullHouse(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.fullHouse(2, 2, 3, 3, 4));
        assertEquals(0, Yatzy.fullHouse(4, 4, 4, 4, 4));
    }
}