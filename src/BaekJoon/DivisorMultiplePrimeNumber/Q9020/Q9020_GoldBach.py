"""
# Author    : Lee In Bok 
# Date      : 2023.12.24(Sun)
# Spend Time: 35m 50s
# Runtime   : 31120 KB
# Memory    : 72 ms
# Algoritm  : Prime Number
"""

import sys
input = sys.stdin.readline

MAX = 10001
arr = [True for _ in range(MAX)]

for num in range(2, MAX):
    if not arr[num]:
      continue

    next = num + num
    while next < MAX:
      arr[next] = False
      next = next + num

T = int(input())

for _ in range(T):
  num = int(input())

  for idx in range(num // 2, 0, -1):
    if not arr[idx]:
      continue

    gap = num - idx

    if arr[gap]:
      print(idx, gap)
      break