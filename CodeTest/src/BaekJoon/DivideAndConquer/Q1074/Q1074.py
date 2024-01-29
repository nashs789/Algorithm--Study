"""
# Author    : Lee In Bok 
# Date      : 2023.12.28(Thu)
# Spend Time: 1h 25m
# Runtime   : 40 ms
# Memory    : 31120 KB
# Algoritm  : Prime Number
"""

import sys
N, r, c = map(int, sys.stdin.readline().split())
cnt = -1

def search(x, y, n):
  global r, c, cnt

  next_n = n // 2
  quad_cnt = pow(next_n, 2)

  if n != 2:
    if x <= r < x + next_n and y <= c < y + next_n:
      search(x, y, next_n)
    elif x <= r < x + next_n and next_n <= c:
      cnt += quad_cnt
      search(x, y + next_n, next_n)
    elif next_n <= r and y <= c < y + next_n:
      cnt += quad_cnt * 2
      search(x + next_n, y, next_n)
    else:
      cnt += quad_cnt * 3
      search(x + next_n, y + next_n, next_n)
    return

  for i in range(x, x + 2):
    for j in range(y, y + 2):
      cnt += 1
      if i == r and j == c:
        print(cnt)
        sys.exit()

search(0, 0, pow(2, N))