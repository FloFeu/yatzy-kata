package com.neiloe;

import java.util.*;
import java.util.Map.Entry;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;

public class DiceRoll {

    private final List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int totalOfPoints() {
        return dice.stream().mapToInt(die -> die).sum();
    }

    public boolean isYatzy() {
        for (int die : dice) {
            if (die != dice.get(0)) {
                return false;
            }
        }
        return true;
    }

    public int countValues(int value) {
        int sum = 0;
        for (Integer die : dice) {
            if (die == value) sum++;
        }
        return sum;
    }

    public List<Integer> getPairs() {
        List<Integer> diceSorted = sortFromHighestToLowest();
        List<Integer> pairs = new ArrayList<>();

        for (int i = 0; i < diceSorted.size() - 1; i++) {
            int currentDie = diceSorted.get(i);
            int nextDie = diceSorted.get(i + 1);

            if (currentDie == nextDie && !pairs.contains(currentDie)) {
                pairs.add(currentDie);
            }
        }

        return pairs;
    }

    public List<Integer> sortFromHighestToLowest() {
        List<Integer> diceSorted = new ArrayList<>(dice);
        diceSorted.sort(Collections.reverseOrder());
        return diceSorted;
    }

    public Integer getDiceValueFoundMoreThan(int number) {
        return dice.stream()
                .collect(groupingBy(identity()))
                .entrySet()
                .stream().filter(map -> map.getValue().size() >= number)
                .map(Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    public boolean isSmallStraight() {
        List<Integer> smallStraight = Arrays.asList(1, 2, 3, 4, 5);
        return dice.containsAll(smallStraight);
    }

    public boolean isLargeStraight() {
        List<Integer> largeStraight = Arrays.asList(2, 3, 4, 5, 6);
        return dice.containsAll(largeStraight);
    }

    public boolean isFullHouse() {
        List<Integer> diceValues = dice.stream()
                .collect(groupingBy(identity()))
                .entrySet()
                .stream()
                .map(Entry::getKey)
                .toList();

        return diceValues.size() == 2;
    }
}
