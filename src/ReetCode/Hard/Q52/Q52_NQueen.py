class Solution:
    def totalNQueens(self, n: int) -> int:
        self.ans, self.n = 0, n
        self.vis1 = [0 for _ in range(n)]
        self.vis2 = [0 for _ in range(n * 2 -1)]
        self.vis3 = [0 for _ in range(n * 2 -1)]

        self.backtracking(0)    # 0번 row부터 시작
            
        return self.ans
    
    def backtracking(self, row: int):
        if row == self.n:
            self.ans += 1
            return

        for idx in range(self.n):
            if not self.vis1[idx] and not self.vis2[idx + row] and not self.vis3[row - idx + (self.n - 1)]:
                self.vis1[idx] = self.vis2[idx + row] = self.vis3[row - idx + (self.n - 1)] = True
                self.backtracking(row + 1)
                self.vis1[idx] = self.vis2[idx + row] = self.vis3[row - idx + (self.n - 1)] = False

s = Solution()
result = s.totalNQueens(8)

print(result)