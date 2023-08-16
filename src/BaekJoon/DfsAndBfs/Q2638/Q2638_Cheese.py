import sys

def is_valid(x, y):
    return 0 <= x < N and 0 <= y < M


def melt_cheese(list, visited):
    remove_list = []

    for t in list:
        x, y = t[0], t[1]
        air_cnt = 0
        
        for idx in range(4):
            nextX = x + move[idx][0]
            nextY = y + move[idx][1]

            if is_valid(nextX, nextY) and board[nextX][nextY] == 0 and visited[nextX][nextY]:
                air_cnt += 1

                if air_cnt >= 2:
                    remove_list.append((x, y))
                    break

    for t in remove_list:
        board[t[0]][t[1]] = 0

def BFS():
    queue = list()
    is_more = True
    hour = 0
    
    while is_more:
        visited = [[False] * M for _ in range(N)]
        cheese = []
        queue.append((0, 0))
        visited[0][0] = True
        cnt = 0

        while len(queue) > 0:
            cur_point = queue.pop(0)

            for i in range(4):
                nextX = cur_point[0] + move[i][0]
                nextY = cur_point[1] + move[i][1]

                if is_valid(nextX, nextY) and not visited[nextX][nextY]:
                    if board[nextX][nextY] == 1:
                        cnt += 1
                        cheese.append((nextX, nextY))    
                        continue 

                    visited[nextX][nextY] = True
                    queue.append((nextX, nextY))
        
        if cnt == 0:
            is_more = False
            break

        melt_cheese(cheese, visited)
        hour += 1
        
    print(hour)


if __name__ == "__main__":
    move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    N, M = map(int, sys.stdin.readline().split())
    board = []
    
    for _ in range(N):
        board.append(list(map(int, sys.stdin.readline().split())))

    BFS()