import sys
from heapq import heappop, heappush
inp = sys.stdin.readline

N = int(inp())
times, heap = [], []

for _ in range(N):
  S, T = map(int, inp().split())
  
  heappush(times, (S, T))

S, T = heappop(times)
heappush(heap, (T, S))

while times:
  srt, end = heappop(times)

  if heap[0][0] <= srt:
    heappop(heap)

  heappush(heap, (end, srt))

print(len(heap))