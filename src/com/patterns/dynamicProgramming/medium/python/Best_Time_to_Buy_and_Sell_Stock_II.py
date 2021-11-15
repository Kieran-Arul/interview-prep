# leetcode Q122
# Input: prices = [7,1,5,3,6,4]
# Output: 7
# Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
# Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
# Total profit is 4 + 3 = 7.

# general idea:
# sell only next up
# buy only next down
prices = [1,2,3,4,5]
# Peak Valley Approach
def PVA_maxProfit(prices):
    low_price = -1
    profit = 0
    total_profit = 0
    next_price = 0
    for date in range(len(prices)):
        day_price = prices[date]
        if date+1 <= len(prices) -1 :
            next_price = prices[date + 1]
        if day_price >= next_price:
            if low_price != -1:
                profit = day_price - low_price
                total_profit = profit + total_profit
                low_price = -1
            continue
        elif day_price < next_price:
            if low_price != -1:
                profit = day_price - low_price
                total_profit = profit + total_profit
                low_price = -1
            low_price = day_price
            continue
    return total_profit
# example: [1, 7, 2, 3, 6, 7, 6, 7], and draw graph to see what is happening
def DP_maxProfit(prices):
    max_price = 0
    for i in range(1,len(prices)):
        if prices[i] > prices[i-1]:
            max_price += prices[i] - prices[i-1]
    return max_price

print(PVA_maxProfit(prices),4)
print(DP_maxProfit(prices),4)