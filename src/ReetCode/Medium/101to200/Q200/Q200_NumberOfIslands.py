class Solution:
    move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    rows = None
    cols = None

    def numIslands(self, grid: list[list[str]]) -> int:
        self.rows, self.cols = len(grid), len(grid[0])
        ans = 0

        for x in range(self.rows):
            for y in range(self.cols):
                if grid[x][y] == "1":
                    ans += 1
                    self.dfs(grid, x, y)
        
        return ans

    def dfs(self, grid: list[list[str]], x: int, y: int) -> None:
        if grid[x][y] == "0":
            return
        
        grid[x][y] = "0"
        
        for moveX, moveY in self.move:
            newX = moveX + x
            newY = moveY + y

            if self.isValid(newX, newY) and grid[newX][newY] == "1":
                self.dfs(grid, newX, newY)

    def isValid(self, x, y) -> bool:
        return 0 <= x < self.rows and 0 <= y < self.cols 

s = Solution()
result = s.numIslands([
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
])

print(result)