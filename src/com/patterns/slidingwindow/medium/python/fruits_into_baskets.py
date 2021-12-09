# LeetCode Q904
# You are visiting a farm that has a single row of fruit trees arranged from left to right.
# The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

# You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

# 1. You only have two baskets, and each basket can only hold a single type of fruit.
# There is no limit on the amount of fruit each basket can hold.

# 2. Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
# while moving to the right. The picked fruits must fit in one of your baskets.

# 3. Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
# Given the integer array fruits, return the maximum number of fruits you can pick.

# Example 1:
# Input: fruits = [1,2,1]
# Output: 3
# Explanation: We can pick from all 3 trees.

# Example 2:
# Input: fruits = [0,1,2,2]
# Output: 3
# Explanation: We can pick from trees [1,2,2]. If we had started at the first tree, we would only pick from trees [0,1].

from typing import List


def fruits_in_baskets(fruits: List[int]) -> int:

    basket = {}
    window_start = 0
    window_end = 0
    fruits_collected = 0
    collection_list = []

    while window_end < len(fruits):

        if (len(basket.keys()) < 2) or (fruits[window_end] in basket):

            fruits_collected += 1
            basket[fruits[window_end]] = 0
            window_end += 1

        else:

            collection_list.append(fruits_collected)
            fruits_collected = 0
            basket = {}
            window_start += 1
            window_end = window_start

    collection_list.append(fruits_collected)

    return max(collection_list)


print(fruits_in_baskets([1, 2, 1]))
print(fruits_in_baskets([0, 1, 2, 2]))
print(fruits_in_baskets([0, 1, 6, 6, 4, 4, 6]))
