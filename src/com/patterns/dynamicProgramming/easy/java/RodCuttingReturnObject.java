package com.patterns.dynamicProgramming.easy.java;

public class RodCuttingReturnObject {

    private final int profit;
    private final int[] cutsTable;

    public RodCuttingReturnObject(int profit, int[] cutsTable) {
        this.profit = profit;
        this.cutsTable = cutsTable;
    }

    public int getProfit() {
        return this.profit;
    }

    public int[] getCutsTable() {
        return this.cutsTable;
    }

}
