package com.neiloe;

import java.util.*;

public class DiceRoll {

    private final List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int totalOfPoints() {
        return dice.stream().mapToInt(die -> die).sum();
    }

    public boolean isYatzy() {
        for (int die : dice ) {
            if (die != dice.get(0)) {
                return false;
            }
        }
        return true;
    }

    public int countValues(int value) {
        int sum = 0;
        for (Integer die : dice) {
            if (die == value) sum ++;
        }
        return sum;
    }

    public int findPair() {

        List<Integer> diceSorted = sortFromHighestToLowest();

        for (int i = 0; i < diceSorted.size() - 1; i++) {

            Object currentDie = diceSorted.get(i);
            Object nextDie = diceSorted.get(i + 1);

            if (currentDie == nextDie) {
                return (int) currentDie * 2;
            }

        }
        return 0;
    }

    public List<Integer> sortFromHighestToLowest() {
        ArrayList<Integer> diceSorted = new ArrayList<>(dice);
        diceSorted.sort(Collections.reverseOrder());
        return diceSorted;
    }

    public int findTwoPairs() {
        int foundPair = 0;
        ArrayList<Integer> pairs = new ArrayList<>();

        List<Integer> diceSorted = sortFromHighestToLowest();

        for (int i = 0; i < diceSorted.size() - 1; i++) {

            int currentDie = diceSorted.get(i);
            int nextDie = diceSorted.get(i + 1);
            boolean isPair = currentDie == nextDie;

            if (isPair && isAnotherPair(pairs, currentDie)) {
                pairs.add(currentDie);
                foundPair++;
            }
        }

        if (foundPair >= 2) {
            return (pairs.get(0) + pairs.get(1)) * 2;
        }
        return 0;
    }

    private boolean isAnotherPair(ArrayList<Integer> pairs, int currentDie) {
        return !pairs.contains(currentDie);
    }

    public int threeOfAKind() {
        List<Integer> diceSorted = sortFromHighestToLowest();

        for (int i = 0; i < diceSorted.size() - 2; i++) {

            boolean threeDiceAreEqual = Objects.equals(diceSorted.get(i), diceSorted.get(i + 1))
                    && Objects.equals(diceSorted.get(i + 1), diceSorted.get(i + 2));

            if (threeDiceAreEqual) {
                return diceSorted.get(i) * 3;
            }
        }
        return 0;
    }

    public int fourOfAKind() {
        List<Integer> diceSorted = sortFromHighestToLowest();

        for (int i = 0; i < diceSorted.size() - 3; i++) {

            boolean fourDiceAreEqual = Objects.equals(diceSorted.get(i), diceSorted.get(i + 1))
                    && Objects.equals(diceSorted.get(i + 1), diceSorted.get(i + 2))
                    && Objects.equals(diceSorted.get(i + 2), diceSorted.get(i + 3));

            if (fourDiceAreEqual) {
                return diceSorted.get(i) * 4;
            }
        }
        return 0;
    }

    public int smallStraight() {
        List<Integer> smallStraight = Arrays.asList(1, 2, 3, 4, 5);

        if (dice.containsAll(smallStraight)) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        List<Integer> largeStraight = Arrays.asList(2, 3, 4, 5, 6);

        if (dice.containsAll(largeStraight)) {
            return 20;
        }
        return 0;
    }

}
