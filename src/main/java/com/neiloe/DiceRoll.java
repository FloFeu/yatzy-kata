package com.neiloe;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;

public class DiceRoll {

    private static final List<Integer> SMALL_STRAIGHT = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = List.of(2, 3, 4, 5, 6);
    private final List<Integer> dice;

    private DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = List.of(d1, d2, d3, d4, d5);
    }

    public static DiceRoll of(int d1, int d2, int d3, int d4, int d5) {
        return new DiceRoll(d1, d2, d3, d4, d5);
    }

    public int totalOfPoints() {
        return dice.stream()
            .mapToInt(die -> die)
            .sum();
    }

    public boolean isYatzy() {
        return dice.stream()
            .mapToInt(die -> die)
            .noneMatch(die -> die != dice.get(0));
    }

    public int countValues(int value) {
        return (int) dice.stream()
            .filter(die -> die == value)
            .count();
    }

    public List<Integer> findPairs(int number) {
        return getValueOfFilteredDice(number)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public Integer getDiceValueFoundMoreThan(int number) {
        return getValueOfFilteredDice(number)
                .findFirst()
                .orElse(0);
    }

    private Stream<Integer> getValueOfFilteredDice(int number) {
        return getDiceGroupedByValues()
                .entrySet()
                .stream()
                .filter(map -> map.getValue().size() >= number)
                .map(Entry::getKey);
    }

    private Map<Integer, List<Integer>> getDiceGroupedByValues() {
        return dice.stream()
                .collect(groupingBy(identity()));
    }

    public boolean isSmallStraight() {
        return dice.containsAll(SMALL_STRAIGHT);
    }

    public boolean isLargeStraight() {
        return dice.containsAll(LARGE_STRAIGHT);
    }

    public boolean isFullHouse() {
        List<Integer> diceValues = getDiceGroupedByValues()
                .keySet()
                .stream()
                .toList();

        return diceValues.size() == 2;
    }
}
