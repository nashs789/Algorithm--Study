"""
# Author    : Lee In Bok 
# Date      : 2023.12.25(Mon)
# Spend Time: 52m 37s
# Runtime   : 42352 KB
# Memory    : 816 ms
# Algoritm  : Binary Search
"""

import sys
inp = sys.stdin.readline

M, N, L = map(int, inp().split())
loc = list(map(int, inp().split()))
loc.sort()
animals = []

cnt = 0

for idx in range(N):
  l, r = 0, len(loc) - 1
  x, y = map(int, inp().split())

  while l <= r:
    mid = (l + r) // 2

    if abs(loc[mid] - x) + y <= L:
      cnt += 1
      break

    if loc[mid] - x > 0:
      r = mid - 1
    else:
      l = mid + 1

print(cnt)