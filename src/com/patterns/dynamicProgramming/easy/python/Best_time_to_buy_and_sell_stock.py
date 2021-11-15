# leetcode Q121
# Input: prices = [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
# Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


prices = [7,1,5,3,6,4]
# method 1
def maxProfit1(prices):
    profit = 0
    # set low price
    low_price = prices[0]
    # find all price
    for price in prices:
        # if found lower price, replace it
        if price < low_price:
            low_price = price
        # if not lower price, then calculate profit and compare it
        else:
            profit = max(profit,price - low_price)
    return profit
print(maxProfit1(prices),5)
