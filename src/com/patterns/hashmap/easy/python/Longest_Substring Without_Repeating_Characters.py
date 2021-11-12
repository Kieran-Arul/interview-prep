# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.

# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
# Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

# use hashtable to find the answer
def lengthOfLongestSubstring(s):
    # count repeat word and position: hashtable[word] = potistion
    hashtable = {}
    # final result
    final_count = 0
    begin = 0
    # num:current word position, word: current word
    # for example: 0 p, 1 w, 2 w ...
    # if not sure, run next print code
    for num, word in enumerate(s):
        # print(num,word)
        # if the word is in hashtable
        # it also means if it repeated
        if word in hashtable:
            # move to next
            first_count = hashtable[word] + 1
            # count the begin
            if first_count > begin:
                begin = first_count
        # count the length of non-repeat words
        now_pos = num - begin + 1
        # if longer than before, then replace it
        if now_pos > final_count:
            final_count = now_pos
        # give the position
        hashtable[word] = num
    return final_count

print(lengthOfLongestSubstring("pwwkew"),3)