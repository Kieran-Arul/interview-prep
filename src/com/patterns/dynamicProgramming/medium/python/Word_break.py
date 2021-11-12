
# Input: s = "applepenapple", wordDict = ["apple","pen"]
# Output: true
# Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
# Note that you are allowed to reuse a dictionary word.

s = "leetcode"
wordDict = ["leet","code"]
wordDict = set(wordDict)
Result = []
word_set = set(wordDict)
dp = [False] * (len(s) + 1)
dp[0] = True

for i in range(1, len(s) + 1):
    for j in range(i):
        print(s[j:i])
        if dp[j] and s[j:i] in word_set:
            dp[i] = True
            break
print(dp[len(s)])