package com.dhrs.base.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_COMBINATION = 3;

    public static Set<String> getWinningNumbers() {
        Set<String> winningNumbers = new HashSet<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            for (int j = MIN_NUMBER; j <= MAX_NUMBER; j++) {
                for (int k = MIN_NUMBER; k <= MAX_NUMBER; k++) {
                    if (i == j && j == k) {
                        winningNumbers.add(String.format("%d%d%d", i, j, k));
                    } else if (i == j || j == k || i == k) {
                        winningNumbers.add(String.format("%d%d%d", i, j, k));
                        winningNumbers.add(String.format("%d%d", i, j));
                        winningNumbers.add(String.format("%d%d", j, k));
                        winningNumbers.add(String.format("%d%d", i, k));
                    } else {
                        winningNumbers.add(String.format("%d%d%d", i, j, k));
                        winningNumbers.add(String.format("%d%d", i, j));
                        winningNumbers.add(String.format("%d%d", j, k));
                        winningNumbers.add(String.format("%d%d", i, k));
                        winningNumbers.add(String.format("%d", i));
                        winningNumbers.add(String.format("%d", j));
                        winningNumbers.add(String.format("%d", k));
                    }
                }
            }
        }
        return winningNumbers;
    }

    public static List<String> buyLotteryNumbers(int count) {
        List<String> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int combination = (int) (Math.random() * MAX_COMBINATION);
            if (combination == 0) {
                int digit = (int) (Math.random() * (MAX_NUMBER + 1));
                lotteryNumbers.add(String.valueOf(digit));
            } else if (combination == 1) {
                int digit1 = (int) (Math.random() * (MAX_NUMBER + 1));
                int digit2 = (int) (Math.random() * (MAX_NUMBER + 1));
                while (digit1 == digit2) {
                    digit2 = (int) (Math.random() * (MAX_NUMBER + 1));
                }
                lotteryNumbers.add(String.format("%d%d", digit1, digit2));
            } else {
                int digit1 = (int) (Math.random() * (MAX_NUMBER + 1));
                int digit2 = (int) (Math.random() * (MAX_NUMBER + 1));
                int digit3 = (int) (Math.random() * (MAX_NUMBER + 1));
                while (digit1 == digit2 || digit2 == digit3 || digit1 == digit3) {
                    digit1 = (int) (Math.random() * (MAX_NUMBER + 1));
                    digit2 = (int) (Math.random() * (MAX_NUMBER + 1));
                    digit3 = (int) (Math.random() * (MAX_NUMBER + 1));
                }
                lotteryNumbers.add(String.format("%d%d%d", digit1, digit2, digit3));
            }
        }
        return lotteryNumbers;
    }

    public static void main(String[] args) {
        Set<String> winningNumbers = getWinningNumbers();
        List<String> lotteryNumbers = buyLotteryNumbers(10);
        int totalPrize = 0;
        int bigPrize = 0;
        int smallPrize = 0;
        int singlePrize = 0;
        for (String number : lotteryNumbers) {
            if (winningNumbers.contains(number)) {
                if (number.length() == 1) {
                    singlePrize++;
                } else if (number.length() == 2) {
                    smallPrize++;
                } else {
                    bigPrize++;
                }
                totalPrize++;
            }
        }
        System.out.printf("Winning numbers: %s%n", winningNumbers);
        System.out.printf("Lottery numbers: %s%n", lotteryNumbers);
        System.out.printf("Total prize: %d%n", totalPrize);
        System.out.printf("Big prize: %d%n", bigPrize);
        System.out.printf("Small prize: %d%n", smallPrize);
        System.out.printf("Single prize: %d%n", singlePrize);
    }
}
