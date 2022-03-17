import com.neiloe.DiceRoll;
import com.neiloe.Yatzy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(14, Yatzy.chance(DiceRoll.of(1, 1, 3, 3, 6)));
        assertEquals(21, Yatzy.chance(DiceRoll.of(4, 5, 5, 6, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.yatzy(DiceRoll.of(1, 1, 1, 1, 1)));
        assertEquals(0, Yatzy.yatzy(DiceRoll.of(1, 1, 1, 2, 1)));
    }

    @Test
    public void ones() {
        assertEquals(1, Yatzy.ones(DiceRoll.of(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(DiceRoll.of(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(DiceRoll.of(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(DiceRoll.of(1, 2, 1, 1, 1)));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(DiceRoll.of(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(DiceRoll.of(2, 2, 2, 2, 2)));
    }

    @Test
    public void threes() {
        assertEquals(6, Yatzy.threes(DiceRoll.of(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(DiceRoll.of(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours() {
        assertEquals(12, Yatzy.fours(DiceRoll.of(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy.fours(DiceRoll.of(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy.fours(DiceRoll.of(4, 5, 5, 5, 5)));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(DiceRoll.of(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy.fives(DiceRoll.of(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy.fives(DiceRoll.of(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(DiceRoll.of(4, 4, 4, 5, 5)));
        assertEquals(6, Yatzy.sixes(DiceRoll.of(4, 4, 6, 5, 5)));
        assertEquals(18, Yatzy.sixes(DiceRoll.of(6, 5, 6, 6, 5)));
    }

    @Test
    public void pair() {
        assertEquals(0, Yatzy.pair(DiceRoll.of(1, 2, 3, 4, 5)));
        assertEquals(8, Yatzy.pair(DiceRoll.of(3, 3, 3, 4, 4)));
        assertEquals(12, Yatzy.pair(DiceRoll.of(1, 1, 6, 2, 6)));
        assertEquals(6, Yatzy.pair(DiceRoll.of(3, 3, 3, 4, 1)));
        assertEquals(6, Yatzy.pair(DiceRoll.of(3, 3, 3, 3, 1)));
    }

    @Test
    public void twoPairs() {
        assertEquals(8, Yatzy.twoPairs(DiceRoll.of(1, 1, 2, 3, 3)));
        assertEquals(0, Yatzy.twoPairs(DiceRoll.of(1, 1, 2, 3, 4)));
        assertEquals(6, Yatzy.twoPairs(DiceRoll.of(1, 1, 2, 2, 2)));
        assertEquals(0, Yatzy.twoPairs(DiceRoll.of(3, 3, 3, 3, 1)));

    }

    @Test
    public void threeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(DiceRoll.of(3, 3, 3, 4, 5)));
        assertEquals(0, Yatzy.threeOfAKind(DiceRoll.of(3, 3, 4, 5, 6)));
        assertEquals(9, Yatzy.threeOfAKind(DiceRoll.of(3, 3, 3, 3, 1)));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(8, Yatzy.fourOfAKind(DiceRoll.of(2, 2, 2, 2, 5)));
        assertEquals(0, Yatzy.fourOfAKind(DiceRoll.of(2, 2, 2, 5, 5)));
        assertEquals(8, Yatzy.fourOfAKind(DiceRoll.of(2, 2, 2, 2, 2)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(DiceRoll.of(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(DiceRoll.of(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.smallStraight(DiceRoll.of(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(DiceRoll.of(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(DiceRoll.of(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.largeStraight(DiceRoll.of(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(8, Yatzy.fullHouse(DiceRoll.of(1, 1, 2, 2, 2)));
        assertEquals(0, Yatzy.fullHouse(DiceRoll.of(2, 2, 3, 3, 4)));
        assertEquals(0, Yatzy.fullHouse(DiceRoll.of(4, 4, 4, 4, 4)));
        assertEquals(17, Yatzy.fullHouse(DiceRoll.of(5, 5, 5, 1, 1)));
    }
}