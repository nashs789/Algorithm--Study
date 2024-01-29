# import sys
# from functools import cache
# sys.setrecursionlimit(500 * 500)
# input = sys.stdin.readline
# answer = 0

# def dfs(x, y):

#     @cache
#     def traverse(x, y):
#         if x == 0 and y == 0:
#             return 1
        
#         res = 0

#         for moveX, moveY in move:
#             nextX, nextY  = x + moveX, y + moveY
            
#             if is_valid(nextX, nextY) and board[x][y] < board[nextX][nextY]:
#                 res += traverse(nextX, nextY)
#         return res
    
#     return traverse(x, y)
            

# def is_valid(x, y):
#     return 0 <= x < N and 0 <= y < M

# if __name__ == "__main__":
#     N, M = map(int, input().strip().split())
#     board = [list(map(int, input().strip().split())) for _ in range(N)]
#     move = [[-1, 0], [1, 0], [0, -1], [0, 1]]

#     print(dfs(N - 1, M - 1))

import sys
sys.setrecursionlimit(10 ** 8)
input = sys.stdin.readline

def dfs(x, y):
    if x == N-1 and y == M-1:
        return 1
    
    if dp[x][y] != -1:
        return dp[x][y]
    
    path = 0

    for moveX, moveY in move:
        nextX, nextY  = x + moveX, y + moveY
        
        if is_valid(nextX, nextY) and board[x][y] > board[nextX][nextY]:
            path += dfs(nextX, nextY)

    dp[x][y] = path
    return path

def is_valid(x, y):
    return 0 <= x < N and 0 <= y < M

if __name__ == "__main__":
    N, M = map(int, input().strip().split())
    board = [list(map(int, input().strip().split())) for _ in range(N)]
    dp = [[-1 for _ in range(M)] for _ in range(N)]
    move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    
    print(dfs(0, 0))