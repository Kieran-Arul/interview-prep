package com.patterns.dynamicProgramming.easy.java;

import java.util.List;

public class RodCuttingAnswerObject {

    private final int maxProfit;
    private final List<Integer> cuts;

    public RodCuttingAnswerObject(int maxProfit, List<Integer> cuts) {
        this.maxProfit = maxProfit;
        this.cuts = cuts;
    }

    @Override
    public String toString() {
        return "RodCuttingAnswerObject{" +
                "maxProfit=" + this.maxProfit +
                ", cuts=" + this.cuts +
                '}';
    }

}
