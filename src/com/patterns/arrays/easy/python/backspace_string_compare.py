# Backspace string compare
# LeetCode Q844

# Given two strings s and t, return true if they are equal when both are typed into empty text editors.
# '#' means a backspace character.
# Note that after backspacing an empty text, the text will continue empty.

# Example 1:
# Input: s = "ab#c", t = "ad#c"
# Output: true
# Explanation: Both s and t become "ac".

# Example 2:
# Input: s = "ab##", t = "c#d#"
# Output: true
# Explanation: Both s and t become "".


def backspace_compare(s1, s2):

    return remove_backspaces(s1) == remove_backspaces(s2)


def remove_backspaces(s):

    res = []

    for char in s:

        if char != "#":
            res.append(char)

        else:
            res.pop()

    return "".join(res)


print(backspace_compare("ab#c", "ad#c"))
print(backspace_compare("ab##", "c#d#"))
print(backspace_compare("dsin#jdb#", "dckdo#kfo#"))
