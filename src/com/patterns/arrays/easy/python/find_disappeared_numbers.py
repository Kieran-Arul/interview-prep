# LeetCode Q448
# Given an array nums of n integers where nums[i] is in the range [1, n],
# return an array of all the integers in the range [1, n] that do not appear in nums.

# Example 1:
# Input: nums = [4,3,2,7,8,2,3,1]
# Output: [5,6]

# Example 2:
# Input: nums = [1,1]
# Output: [2]

from typing import List


def find_disappeared_numbers(nums: List[int]) -> List[int]:

    cache = {}
    disappeared_nums = set()

    for num in nums:

        cache[num] = 0

    for each_num in range(1, len(nums) + 1):

        if each_num not in cache:
            disappeared_nums.add(each_num)

    return list(disappeared_nums)


def find_disappeared_numbers_model_answer(nums: List[int]) -> List[int]:

    return list(
        set(range(1, len(nums) + 1)) - set(nums)
    )


print(find_disappeared_numbers_model_answer([4, 3, 2, 7, 8, 2, 3, 1]))
print(find_disappeared_numbers_model_answer([1, 1]))
print(find_disappeared_numbers([4, 3, 2, 7, 8, 2, 3, 1]))
print(find_disappeared_numbers([1, 1]))
