# LeetCode Q1143
# Given two strings text1 and text2, return the length of their longest common subsequence.
# If there is no common subsequence, return 0.

# A subsequence of a string is a new string generated from the original string with some characters
# (can be none) deleted without changing the relative order of the remaining characters.

# For example, "ace" is a subsequence of "abcde".
# A common subsequence of two strings is a subsequence that is common to both strings.

# Example 1:
# Input: text1 = "abcde", text2 = "ace"
# Output: 3
# Explanation: The longest common subsequence is "ace" and its length is 3.

# Example 2:
# Input: text1 = "abc", text2 = "abc"
# Output: 3
# Explanation: The longest common subsequence is "abc" and its length is 3.

# Example 3:
# Input: text1 = "abc", text2 = "def"
# Output: 0
# Explanation: There is no such common subsequence, so the result is 0.

def lcs(s1, s2, cache):

    len_of_s1 = len(s1)
    len_of_s2 = len(s2)

    if (len_of_s1 == 0) or (len_of_s2 == 0):
        return 0

    if (len_of_s1, len_of_s2) in cache:
        return cache[(len_of_s1, len_of_s2)]

    if s1[-1] == s2[-1]:
        cache[(len_of_s1, len_of_s2)] = 1 + lcs(s1[:-1], s2[:-1], cache)
        return cache[(len_of_s1, len_of_s2)]

    else:
        cache[(len_of_s1 - 1, len_of_s2)] = lcs(s1[:-1], s2, cache)
        cache[(len_of_s1, len_of_s2 - 1)] = lcs(s1, s2[:-1], cache)
        return max(cache[(len_of_s1 - 1, len_of_s2)], cache[(len_of_s1, len_of_s2 - 1)])


def lcs_driver(s1, s2):

    cache = {}

    return lcs(s1, s2, cache)


print(lcs_driver("abcde", "ace"))
print(lcs_driver("abc", "abc"))
print(lcs_driver("abc", "def"))
