import sys
inp = sys.stdin.readline

cnt = 0
N, M = map(int, inp().split())
x, y, D = map(int, inp().split())
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
maps = [list(map(int, inp().split())) for _ in range(N)]

def is_path(x, y):
  for idx in range(4):
    nx, ny = x + dx[idx], y + dy[idx]

    if is_valid(nx, ny) and maps[nx][ny] == 0:
      return True

  return False

def is_valid(x, y):
  return 0 <= x < N and 0 <= y < M

while(True):
  if maps[x][y] == 0:
    maps[x][y] = -1
    cnt += 1

  if is_path(x, y):
    for _ in range(4):
      nx, ny = x + dx[D - 1], y + dy[D - 1]
      D = 3 if D - 1 == -1 else D - 1

      if maps[nx][ny] == 0:
        x, y = nx, ny
        break
  else:  # 4 방향 전부 갈 수 없는 경우
    if D == 0:
      x += 1
    elif D == 1:
      y -= 1
    elif D == 2:
      x -= 1
    elif D == 3:
      y += 1
    
    if not is_valid(x, y) or maps[x][y] == 1:
      break
    
print(cnt)