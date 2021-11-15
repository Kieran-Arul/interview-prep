package com.patterns.twoPointers.easy.java;

//        Problem Statement
//        Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
//        after removing the duplicates in-place return the new length of the array.

//        Input: [2, 3, 3, 3, 6, 9, 9]
//        Output: 4
//        Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

//        Input: [2, 2, 2, 11]
//        Output: 2
//        Explanation: The first two elements after removing the duplicates will be [2, 11].

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] test = {2, 3, 3, 3, 6, 9, 9};
        int[] test2 = {2, 2, 2, 11};

        System.out.println(removeDuplicates(test));
        System.out.println(removeDuplicates(test2));

    }

    private static int removeDuplicates(int[] arr) {

        int newLength = 1;

        int arrPointer = 1;

        while (arrPointer < arr.length) {

            if (arr[arrPointer] != arr[arrPointer - 1]) {
                newLength++;
            }

            arrPointer++;

        }

        return newLength;

    }

}
