"""
From Grokking the Coding Interview

Problem Statement 
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:
Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6

Example 2:
Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11
"""

# SOLUTION BREAKDOWN:
#
# - Fundamentally we want to go through the sorted array and pair off numbers, checking if their sum == target sum
#
# - We initialise two pointers, one at the start of the array, the other at the end
#
# - We have a while condition to ensure the pointers do not cross because then we would be repeating pairs
#
# - Then with every pair, we check if they meet the target sum
#
# - If the target is met, we return the two pairs
#
# - If we are under the target sum, then we know we need to increase the current sum, thus we increment the left pointer
# because we know the array is sorted and doing so will give us an equal/greater number
#
# - If we are over the target sum, then we know we need to decrease the current sum, thus we decrement the left pointer
# because we know the array is sorted and doing so will give us an equal/smaller number


def pair_with_target_sum(arr, target_sum):

    left_pointer = 0
    right_pointer = len(arr) - 1

    while left_pointer < right_pointer:

        current_sum = arr[left_pointer] + arr[right_pointer]

        if current_sum == target_sum:
            return [left_pointer, right_pointer]

        elif current_sum > target_sum:
            right_pointer -= 1

        else:
            left_pointer += 1

    return [-1, -1]


print(pair_with_target_sum([1, 2, 3, 4, 6], 6))
print(pair_with_target_sum([2, 5, 9, 11], 11))
