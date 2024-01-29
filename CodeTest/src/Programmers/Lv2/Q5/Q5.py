"""
# Author    : Lee In Bok 
# Date      : 2023.12.30(Sat)
# Spend Time: 09m 27s
# Runtime   : 31.53 ms (Longest Time)
# Memory    : 12 MB (Most Spacious)
# Algoritm  : Dynamic Programming
"""

def solution(n):
    if n == 0 or n == 1:
       return 1

    dp = [0 for _ in range(n + 1)]
    dp[0] = 1
    dp[1] = 1

    for idx in range(2, n + 1):
      dp[idx] = (dp[idx - 2] + dp[idx - 1]) % 1000000007

    return dp[n]

res = solution(10)
print(res)