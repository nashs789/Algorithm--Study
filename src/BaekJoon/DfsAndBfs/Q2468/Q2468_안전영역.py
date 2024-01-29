import sys
sys.setrecursionlimit(10000)
inp = sys.stdin.readline

N = int(inp())
max_area = 0
max_height = 0
water_height = 0
dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]
world = [list(map(int, inp().split())) for _ in range(N)]

def dfs(x, y, visited):
  global safe_area

  for direction in dir:
    next_x = x + direction[0]
    next_y = y + direction[1]

    if isValid(next_x, next_y) and not visited[next_x][next_y] and world[next_x][next_y] > water_height:
      visited[next_x][next_y] = True
      dfs(next_x, next_y, visited)

def isValid(x, y):
  return 0 <= x < N and 0 <= y < N

while True:
  visited = [[False for _ in range(N)] for _ in range(N)]
  area_cnt = 0
  dfs_cnt = 0

  for i in range(N):
    for j in range(N):
      if world[i][j] <= water_height:
        visited[i][j] = True
        continue

      if not visited[i][j]:
        dfs(i, j, visited)
        area_cnt += 1
        dfs_cnt += 1

  if dfs_cnt == 0:
    break

  if area_cnt > max_area:
    max_area = area_cnt
    max_height = water_height
  
  water_height += 1

print(max_area)