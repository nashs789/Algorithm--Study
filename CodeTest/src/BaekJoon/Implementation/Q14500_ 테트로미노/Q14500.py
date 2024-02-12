import sys
inp = sys.stdin.readline

N, M = map(int, inp().split())
dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]
visited = [[False] * M for _ in range(N)]
maps = [list(map(int, inp().split())) for _ in range(N)]
ans = 0

def dfs(x, y, sums, cnt):
  global ans

  if cnt == 4:
    ans = max(ans, sums)
    return

  for i in range(4):
    nx, ny = x + dx[i], y + dy[i]

    if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
      visited[nx][ny] = True
      dfs(nx, ny, sums + maps[nx][ny], cnt + 1)
      visited[nx][ny] = False
      
# ㅏ ㅜ ㅗ ㅓ 4방향 검사
def extra(x, y):
  global ans

  for i in range(4):
    sums = maps[x][y]

    for j in range(-1, 2, 1):
      idx = i + j if i + j != 4 else 0
      nx, ny = x + dx[idx], y + dy[idx]

      if not 0 <= nx < N or not 0 <= ny < M:
        break
      
      sums += maps[nx][ny]
    ans = max(ans, sums)        

for i in range(N):
  for j in range(M):
    visited[i][j] = True
    dfs(i, j, maps[i][j], 1)
    visited[i][j] = False
    extra(i, j)

print(ans)