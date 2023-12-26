"""
# Author    : Lee In Bok 
# Date      : 2023.12.26(Tue)
# Spend Time: 16m 24s
# Runtime   : 892 ms
# Memory    : 38848 KB
# Algoritm  : Binary Search
"""

import sys
inp = sys.stdin.readline

N, C = map(int, inp().split())
houses = [int(inp()) for _ in range(N)]
houses.sort()

l, r = 1, houses[-1]
min_dist = sys.maxsize

while l <= r:
  mid = (l + r) // 2
  cur_loc, cnt = 0, 1  # 현재 위치, 공유기 설치 수
  
  for idx in range(N):
    if houses[idx] - houses[cur_loc] >= mid:
      cnt += 1
      cur_loc = idx

  if cnt >= C:
    min_dist = mid
    l = mid + 1
  else:
    r = mid - 1

print(min_dist)