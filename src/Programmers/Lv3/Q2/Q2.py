"""
# Author    : Lee In Bok 
# Date      : 2023.12.31(Sun)
# Problem   : 거스름돈
# Spend Time: 15m 01s
# Runtime   : 457.90 ms (Longest Time)
# Memory    : 13 MB (Most Spacious)
# Algoritm  : Dynamic Programming
"""

def solution(n, money):
    dp = [0 for _ in range(n + 1)]
    dp[0] = 1

    for i in money:
        for j in range(i, n + 1):
            dp[j] += dp[j - i]

    return dp[n]

res = solution(5, [1,2,5])
print(res)