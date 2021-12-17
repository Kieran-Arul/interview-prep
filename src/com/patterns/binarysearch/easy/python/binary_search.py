# LeetCode Q704

# Given an array of integers nums which is sorted in ascending order, and an integer target,
# write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
# You must write an algorithm with O(log n) runtime complexity.

# Example 1:
# Input: nums = [-1,0,3,5,9,12], target = 9
# Output: 4
# Explanation: 9 exists in nums and its index is 4

# Example 2:
# Input: nums = [-1,0,3,5,9,12], target = 2
# Output: -1
# Explanation: 2 does not exist in nums so return -1

from typing import List


def binary_search(nums: List[int], target: int) -> int:
    left_ptr = 0
    right_ptr = len(nums) - 1

    while left_ptr <= right_ptr:

        midpoint = left_ptr + ((right_ptr - left_ptr) // 2)

        if target == nums[midpoint]:
            return midpoint

        if target < nums[midpoint]:
            right_ptr = midpoint - 1

        else:
            left_ptr = midpoint + 1

    return -1


print(binary_search([-1, 0, 3, 5, 9, 12], 9))
print(binary_search([-1, 0, 3, 5, 9, 12], 2))
