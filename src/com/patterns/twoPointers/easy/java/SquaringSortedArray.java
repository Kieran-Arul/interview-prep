package com.patterns.twoPointers.easy.java;

//        From Grokking the Coding Interview

//        Problem Statement:
//        Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

//        Example 1:
//        Input: [-2, -1, 0, 2, 3]
//        Output: [0, 1, 4, 4, 9]

//        Example 2:
//        Input: [-3, -1, 0, 1, 2]
//        Output: [0 1 1 4 9]

/*

SOLUTION BREAKDOWN:

- More understandable if I comment the code itself

*/

import java.util.Arrays;

public class SquaringSortedArray {

    public static void main(String[] args) {

        int[] test = {-2, -1, 0, 2, 3};
        int[] test2 = {-3, -1, 0, 1, 2};

        System.out.println(Arrays.toString(squaringSortedArray(test)));
        System.out.println(Arrays.toString(squaringSortedArray(test2)));

    }

    private static int[] squaringSortedArray(int[] arr) {

        // Pointer to first element in arr
        int leftPointer = 0;

        // Pointer to last element in arr
        int rightPointer = arr.length - 1;

        // Pointer to last element in squares array
        int squareArrPointer = arr.length - 1;

        int[] squares = new int[arr.length];

        // We also need to deal with the case when leftPointer == rightPointer because
        // otherwise we will forget about the final element in the original array
        while (leftPointer <= rightPointer) {

            // Get the square of each pair
            int leftPointerSquared = (int) Math.pow(arr[leftPointer], 2);
            int rightPointerSquared = (int) Math.pow(arr[rightPointer], 2);

            // If we are on the last element that has not been dealt with yet
            if (leftPointer == rightPointer) {
                squares[squareArrPointer] = leftPointerSquared;
                break;
            }

            // If the right element is greater than the left, add the right element squared to the new array
            // Decrement the squareArrPointer because we know that since the array is sorted, nothing can be bigger than what just added
            if (rightPointerSquared > leftPointerSquared) {
                squares[squareArrPointer] = rightPointerSquared;
                squareArrPointer--;
                rightPointer--;
            }

            // If the two numbers are equal, we need to add both of them squared to the new array
            // First we add the right element, then we need to decrement the pointer in the new array so we are at
            // the correct position to add the left element
            // We then need to change both pointers in the original array because we have dealt with both those numbers
            // at the same time
            else if (leftPointerSquared == rightPointerSquared) {

                squares[squareArrPointer] = rightPointerSquared;
                squareArrPointer--;
                rightPointer--;

                squares[squareArrPointer] = leftPointerSquared;
                squareArrPointer--;
                leftPointer++;

            }

            // If the left element is greater than the right, add the left element squared to the new array
            // Decrement the squareArrPointer because we know that since the array is sorted, nothing can be bigger than what just added
            else {
                squares[squareArrPointer] = leftPointerSquared;
                squareArrPointer--;
                leftPointer++;
            }

        }

        return squares;

    }

}
