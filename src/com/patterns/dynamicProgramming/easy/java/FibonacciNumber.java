package com.patterns.dynamicProgramming.easy.java;

import java.util.HashMap;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fibDriver(5));
        System.out.println(fibDriver(6));
        System.out.println(fibDriver(7));
    }

    private static int fibDriver(int n) {

        HashMap<Integer, Integer> cache = new HashMap<>();

        return fib(n, cache);

    }

    private static int fib(int n, HashMap<Integer, Integer> cache) {

        if (n < 0) {
            return -1;
        }

        if (n == 0 || n == 1) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        cache.put(n, fib(n-1, cache) + fib(n-2, cache));

        return cache.get(n);

    }

}
