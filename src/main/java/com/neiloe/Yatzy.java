package com.neiloe;

import java.util.List;

public class Yatzy {

    private static final int YATZY_POINTS = 50;
    private static final int ZERO = 0;
    private static final int SMALL_STRAIGHT = 15;
    private static final int LARGE_STRAIGHT = 20;

    private Yatzy() {
    }

    public static int chance(DiceRoll diceRoll) {
        return diceRoll.totalOfPoints();
    }

    public static int yatzy(DiceRoll diceRoll) {
        if (diceRoll.isYatzy()) {
            return YATZY_POINTS;
        }
        return ZERO;
    }

    public static int ones(DiceRoll diceRoll) {
        return diceRoll.countValues(1);
    }

    public static int twos(DiceRoll diceRoll) {
        return diceRoll.countValues(2) * 2;
    }

    public static int threes(DiceRoll diceRoll) {
        return diceRoll.countValues(3) * 3;
    }

    public static int fours(DiceRoll diceRoll) {
        return diceRoll.countValues(4) * 4;
    }

    public static int fives(DiceRoll diceRoll) {
        return diceRoll.countValues(5) * 5;
    }

    public static int sixes(DiceRoll diceRoll) {
        return diceRoll.countValues(6) * 6;
    }

    public static int pair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs(2);

        if (!pairs.isEmpty()) {
            return pairs.get(0) * 2;
        }
        return ZERO;
    }

    public static int twoPairs(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs(2);

        if (pairs.size() >= 2) {
            return (pairs.get(0) + pairs.get(1)) * 2;
        }
        return ZERO;
    }

    public static int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.getDiceValueFoundMoreThan(3) * 3;
    }

    public static int fourOfAKind(DiceRoll diceRoll) {
        return diceRoll.getDiceValueFoundMoreThan(4) * 4;
    }

    public static int smallStraight(DiceRoll diceRoll) {
        if (diceRoll.isSmallStraight()) {
            return SMALL_STRAIGHT;
        }
        return ZERO;
    }

    public static int largeStraight(DiceRoll diceRoll) {
        if (diceRoll.isLargeStraight()) {
            return LARGE_STRAIGHT;
        }
        return ZERO;
    }

    public static int fullHouse(DiceRoll diceRoll) {
        if (diceRoll.isFullHouse() ){
            return diceRoll.totalOfPoints();
        }
        return ZERO;
    }
}


