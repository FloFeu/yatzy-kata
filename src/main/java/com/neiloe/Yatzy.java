package com.neiloe;

public class Yatzy {

    public static int chance(DiceRoll diceRoll) {
        return diceRoll.totalOfPoints();
    }

    public static int yatzy(DiceRoll diceRoll) {
        if (diceRoll.isYatzy() ) {
            return 50;
        }
        return 0;
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
        return diceRoll.findPair();
    }

    public static int twoPairs(DiceRoll diceRoll) {
        return diceRoll.findTwoPairs();
    }

    public static int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.threeOfAKind();
    }

    public static int fourOfAKind(DiceRoll diceRoll) {
        return diceRoll.fourOfAKind();
    }

    public static int smallStraight(DiceRoll diceRoll) {
        return diceRoll.smallStraight();
    }

    public static int largeStraight(DiceRoll diceRoll) {
        return diceRoll.largeStraight();
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}


