from heapq import heappop, heappush

N = int(input())
pos_heap, neg_heap = [], []
ans = 0

for _ in range(N):
  num = int(input())

  if num > 0:
    heappush(pos_heap, (-num, num))
  else:
    heappush(neg_heap, (num, num))

while len(pos_heap) > 1:
  x = heappop(pos_heap)[1]
  y = heappop(pos_heap)[1]

  if x == 1 or y == 1:
    ans += x + y
    continue

  ans += (x * y)

if pos_heap:
  ans += heappop(pos_heap)[1]

while len(neg_heap) > 1:
  x = heappop(neg_heap)[1]
  y = heappop(neg_heap)[1]    

  ans += (x * y)

if neg_heap:
  ans += heappop(neg_heap)[1]

print(ans)