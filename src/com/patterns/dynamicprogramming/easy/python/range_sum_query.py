# LeetCode Q303
# Given an integer array nums, handle multiple queries of the following type:
# Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

# Implement the RangeSumQuery class:
# RangeSumQuery(int[] nums) Initializes the object with the integer array nums.
# int sumRange(int left, int right)
# Returns the sum of the elements of nums between indices left and right inclusive
# (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

# Example:

# Input
# ["NumArray", "sumRange", "sumRange", "sumRange"]
# [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]

# Output
# [null, 1, -1, -3]

# Explanation
# NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
# numArray.sumRange(0, 2); # return (-2) + 0 + 3 = 1
# numArray.sumRange(2, 5); # return 3 + (-5) + 2 + (-1) = -1
# numArray.sumRange(0, 5); # return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

# For type hints
from typing import List


class RangeSumQuery:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.cache = {}

    def sum_range(self, start: int, end: int) -> int:

        if (start > end) or (start < 0) or (end >= len(self.nums)):
            raise ValueError("Invalid start/end index")

        if start == end:
            return self.nums[start]

        if (start, end) in self.cache:
            return self.cache[(start, end)]

        self.cache[(start, end)] = self.sum_range(start, end - 1) + self.nums[end]

        return self.cache[(start, end)]


num_array = RangeSumQuery([-2, 0, 3, -5, 2, -1])

print(num_array.sum_range(0, 2))
print(num_array.sum_range(2, 5))
print(num_array.sum_range(0, 5))
