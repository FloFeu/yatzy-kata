package com.neiloe;

import java.util.Arrays;
import java.util.List;

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
            if (dice.get(i) != dice.get(i + 1)) {
                return 0;
            }
        }
        return 50;
    }
}