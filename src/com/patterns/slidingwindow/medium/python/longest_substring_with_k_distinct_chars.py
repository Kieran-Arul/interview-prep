# Question from Grokking the Coding Interview

# Problem Statement
# Given a string, find the length of the longest substring in it with no more than K distinct characters.

# Example 1:
# Input: String="araaci", K=2
# Output: 4
# Explanation: The longest substring with no more than '2' distinct characters is "araa".

# Example 2:
# Input: String="araaci", K=1
# Output: 2
# Explanation: The longest substring with no more than '1' distinct characters is "aa".

# Example 3:
# Input: String="cbbebi", K=3
# Output: 5
# Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

def answer(s: str, k: int) -> int:

    d = {}

    window_start = 0
    next_window_start = 0
    window_end = 0
    max_length = 0

    while window_end < len(s):

        if (s[window_end] not in d) and (len(d) == k - 1):

            next_window_start = window_end

        if (s[window_end] in d) or (len(d) < k):

            d[s[window_end]] = 0
            window_end += 1

        else:

            max_length = max(max_length, window_end - window_start)
            d = {}

            if k > 1:
                window_end = next_window_start
                window_start = next_window_start

            else:
                window_start = window_end

    return max_length


print(answer("araaci", 2))
print(answer("araaci", 1))
print(answer("cbbebi", 3))
print(answer("gjkkkkiiierran", 3))
