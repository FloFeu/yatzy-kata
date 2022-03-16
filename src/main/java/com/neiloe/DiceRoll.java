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

    public int areEqual() {
        for (int i = 0; i < dice.size() - 1; i++) {
            if (!Objects.equals(dice.get(i), dice.get(i + 1))) {
                return 0;
            }
        }
        return 50;
    }

    public int countValues(int value) {
        int sum = 0;
        for (Integer die : dice) {
            if (die == value) sum += value;
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
}