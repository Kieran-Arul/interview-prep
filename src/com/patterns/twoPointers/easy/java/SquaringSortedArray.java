package com.patterns.twoPointers.easy.java;

//        Problem Statement:
//        Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

//        Example 1:
//        Input: [-2, -1, 0, 2, 3]
//        Output: [0, 1, 4, 4, 9]

//        Example 2:
//        Input: [-3, -1, 0, 1, 2]
//        Output: [0 1 1 4 9]

import java.util.Arrays;

public class SquaringSortedArray {

    public static void main(String[] args) {

        int[] test = {-2, -1, 0, 2, 3};
        int[] test2 = {-3, -1, 0, 1, 2};

        System.out.println(Arrays.toString(squaringSortedArray(test)));
        System.out.println(Arrays.toString(squaringSortedArray(test2)));

    }

    private static int[] squaringSortedArray(int[] arr) {

        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int squareArrPointer = arr.length - 1;
        int[] squares = new int[arr.length];

        while (leftPointer <= rightPointer) {

            int leftPointerSquared = (int) Math.pow(arr[leftPointer], 2);
            int rightPointerSquared = (int) Math.pow(arr[rightPointer], 2);

            if (leftPointer == rightPointer) {
                squares[squareArrPointer] = leftPointerSquared;
                break;
            }

            if (rightPointerSquared > leftPointerSquared) {
                squares[squareArrPointer] = rightPointerSquared;
                squareArrPointer--;
                rightPointer--;
            }

            else if (leftPointerSquared == rightPointerSquared) {
                squares[squareArrPointer] = rightPointerSquared;
                squareArrPointer--;
                rightPointer--;
                squares[squareArrPointer] = leftPointerSquared;
                squareArrPointer--;
                leftPointer++;
            }

            else {
                squares[squareArrPointer] = leftPointerSquared;
                squareArrPointer--;
                leftPointer++;
            }

        }

        return squares;

    }

}
