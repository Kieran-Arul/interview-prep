package com.patterns.arrays.easy.java;

import java.util.ArrayList;

// Backspace string compare
// LeetCode Q844

// Given two strings s and t, return true if they are equal when both are typed into empty text editors.
// '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

public class BackspaceStringCompare {

    public static void main(String[] args) {

        String test = "ab#c";
        String test2 = "ad#c";
        System.out.println(backspaceCompare(test, test2));

        test = "ab##";
        test2 = "c#d#";
        System.out.println(backspaceCompare(test, test2));

        test = "abd#sdjan#";
        test2 = "cdjsad#dsad#jd#";
        System.out.println(backspaceCompare(test, test2));

    }

    private static boolean backspaceCompare(String s1, String s2) {
        return removeBackspaces(s1).equals(removeBackspaces(s2));
    }

    private static String removeBackspaces(String s) {

        ArrayList<Character> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != '#') {

                res.add(s.charAt(i));

            } else {

                res.remove(res.size() - 1);

            }

        }

        StringBuilder sb = new StringBuilder();

        for (char c : res) {
            sb.append(c);
        }

        return sb.toString();

    }

}
