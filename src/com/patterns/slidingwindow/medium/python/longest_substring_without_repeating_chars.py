# LeetCode Q3
# Given a string s, find the length of the longest substring without repeating characters.

# Example 1:
# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.

# Example 2:
# Input: s = "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.

# Example 3:
# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.


def answer(s: str) -> int:

    d = {}

    window_start = 0
    window_end = 0
    ans = 0

    while window_end < len(s):

        if s[window_end] not in d:

            d[s[window_end]] = 0
            window_end += 1

        else:

            ans = max(ans, window_end - window_start)
            d = {}
            window_start += 1
            window_end = window_start

    return max(ans, window_end - window_start)


print(answer("abcabcbb"))
print(answer("bbbbb"))
print(answer("pwwkew"))
print(answer("au"))
print(answer(" "))
