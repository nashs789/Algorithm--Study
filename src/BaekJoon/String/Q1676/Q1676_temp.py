"""
# Author    : Lee In Bok 
# Date      : 2023.11.15(Wen)
# Spend Time: 11m 29s
# Runtime   : 40 ms
# Memory    : 31120 KB
# Algoritm  : BigInteger
"""

import sys

N = int(sys.stdin.readline())
temp = 1

for n in range(1, N + 1):
    temp *= n

result = str(temp)
cnt = 0

for n in result[::-1]:
    if n == '0':
        cnt += 1
    else:
        break

print(cnt)