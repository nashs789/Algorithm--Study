import sys
input = sys.stdin.readline

N = int(input())
arr = []

for idx in range(N):
  arr.append((int(input()), idx))

Max = 0
sorted_arr = sorted(arr)

for i in range(N):
  if Max < sorted_arr[i][1] - i:
    Max = sorted_arr[i][1] - i


print(Max + 1)