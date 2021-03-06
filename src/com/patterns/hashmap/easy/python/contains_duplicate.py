# 
# Given an integer array nums, return true if any value appears at least twice in the array,
# and return false if every element is distinct.

# Input: nums = [1,2,3,1]
# Output: true

# Input: nums = [1,2,3,4]
# Output: false


def contains_duplicate(arr):

    d = {}

    for num in arr:

        if num in d:

            return True

        d[num] = 0

    return False

print(contains_duplicate([1, 2, 3, 1]))
print(contains_duplicate([1, 0, 1, 1]))
print(contains_duplicate([1, 2, 3, 1, 2, 3]))