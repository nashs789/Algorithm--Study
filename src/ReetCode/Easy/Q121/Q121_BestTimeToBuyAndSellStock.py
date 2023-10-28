import math

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        Len = len(prices)
        max_profit, min_price = 0, math.inf

        for price in prices:
            if price < min_price:
                min_price = price
            else:
                max_profit = max(max_profit, (price - min_price))

        return max_profit

s = Solution()
result = s.maxProfit([7,1,5,3,6,4])

print(result)