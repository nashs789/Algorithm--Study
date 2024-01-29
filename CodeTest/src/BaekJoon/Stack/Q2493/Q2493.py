"""
# Author    : Lee In Bok 
# Date      : 2023.12.31(Sun)
# Problem   : 탑
# Spend Time: 15m 21s
# Runtime   : 732 ms
# Memory    : 105504 KB
# Algoritm  : Stack
"""

import sys
inp = sys.stdin.readline

N = int(inp())
height = list(map(int, inp().split()))
top = []

for i in range(N):
  while top and top[-1][1] < height[i]:
    top.pop()

  if not top:
    print(0, end=" ")
  else:
    print(top[-1][0] + 1, end=" ")

  top.append((i, height[i]))