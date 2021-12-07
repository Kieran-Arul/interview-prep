package com.patterns.dynamicProgramming.easy.java;

import java.util.ArrayList;
import java.util.List;

public class RodCutting {

    public static void main(String[] args) {

        int rodLength = 8;
        int[] testPrices = {0, 2, 5, 9, 10, 12, 13, 15, 16};

        System.out.println(rodCuttingDriver(rodLength, testPrices));
        System.out.println(rodCuttingBottomUpDp(rodLength, testPrices));

    }

    private static RodCuttingAnswerObject rodCuttingDriver(int len, int[] prices) {

        int[] maxProfitsTable = new int[len + 1];
        int[] cutsTable = new int[len + 1];

        RodCuttingReturnObject answer = rodCuttingTopDownDp(len, prices, maxProfitsTable, cutsTable);

        List<Integer> answerTable = new ArrayList<>();

        int n = len;

        while (n > 0) {
            answerTable.add(answer.getCutsTable()[n]);
            n -= answer.getCutsTable()[n];
        }

        return new RodCuttingAnswerObject(answer.getProfit(), answerTable);

    }

    private static RodCuttingReturnObject rodCuttingTopDownDp(int len, int[] prices, int[] maxProfitsTable, int[] cutsTable) {

        if (len == 0) {
            return new RodCuttingReturnObject(0, cutsTable);
        }

        if (maxProfitsTable[len] == 0) {

            for (int i = 1; i <= len; i++) {

                int profit = prices[i] + rodCuttingTopDownDp(len - i, prices, maxProfitsTable, cutsTable).getProfit();

                if (profit > maxProfitsTable[len]) {
                    maxProfitsTable[len] = profit;
                    cutsTable[len] = i;
                }

            }

        }

        return new RodCuttingReturnObject(maxProfitsTable[len], cutsTable);

    }

    private static RodCuttingAnswerObject rodCuttingBottomUpDp(int len, int[] prices) {

        int[] maxProfitsTable = new int[len + 1];
        int[] cutsTable = new int[len + 1];

        for (int i = 1; i <= len; i++) {

            for (int j = 1; j <= i; j++) {

                int profit = prices[j] + maxProfitsTable[i - j];

                if (profit > maxProfitsTable[i]) {
                    maxProfitsTable[i] = profit;
                    cutsTable[i] = j;
                }

            }

        }

        int n = len;
        List<Integer> answerTable = new ArrayList<>();

        while (n > 0) {
            answerTable.add(cutsTable[n]);
            n -= cutsTable[n];
        }

        return new RodCuttingAnswerObject(maxProfitsTable[len], answerTable);

    }

}
