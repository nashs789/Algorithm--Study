"""
# Author    : Lee In Bok 
# Date      : 2023.11.01(Wed)
# Spend Time: 미측정
# Runtime   : 1134 ms (Beats 5.14%)
# Memory    : 17.9 MB (Beats 84.89%)
# Algoritm  : Graph
"""

from typing import List
from collections import deque

class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        self.row, self.col = len(grid), len(grid[0])
        ans = 0
        
        for r in range(self.row):
            for c in range(self.col):
                if grid[r][c] == 1:    
                    ans += self.bfs(grid, r, c)

        return ans

    def bfs(self, grid: List[List[int]],x:int, y:int) -> int:
        queue = deque()
        queue.append((x, y))
        cnt = 0

        while queue:
            curX, curY = queue.popleft()

            for moveX, moveY in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                newX = moveX + curX
                newY = moveY + curY

                while self.isValid(newX, newY) and grid[newX][newY] != 1:
                    newX += moveX
                    newY += moveY

                if self.isValid(newX, newY) and grid[newX][newY] == 1:
                    cnt +=1
                    grid[newX][newY] = -1
                    queue.append((newX, newY))

        return cnt

    def isValid(self, x:int, y:int) -> bool:
        return 0 <= x < self.row and 0 <= y < self.col

s = Solution()
result = s.countServers([[1,0],[0,1]])

print(result)