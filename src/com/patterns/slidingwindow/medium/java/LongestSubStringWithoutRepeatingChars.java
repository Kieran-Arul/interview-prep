package com.patterns.slidingwindow.medium.java;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {

        System.out.println(answer("abcabcbb"));
        System.out.println(answer("bbbbb"));
        System.out.println(answer("pwwkew"));
        System.out.println(answer("au"));
        System.out.println(answer(" "));

    }

    private static int answer(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int windowStart = 0;
        int windowEnd = 0;
        int ans = 0;

        while (windowEnd < s.length()) {

            if (!map.containsKey(s.charAt(windowEnd))) {

                map.put(s.charAt(windowEnd), 0);
                windowEnd++;

            } else {

                ans = Math.max(ans, windowEnd - windowStart);
                map.clear();
                windowEnd = ++windowStart;

            }

        }

        return Math.max(ans, windowEnd - windowStart);

    }

}
