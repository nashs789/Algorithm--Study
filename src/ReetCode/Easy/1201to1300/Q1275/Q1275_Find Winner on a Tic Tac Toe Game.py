# =============== sol 1 ===============
"""
# Author    : Lee In Bok 
# Date      : 2023.11.01(Wed)
# Spend Time: 미측정
# Runtime   : 43 ms (Beats 43.51%)
# Memory    : 16.3 MB (Beats 57.69%)
# Algoritm  : ???
"""

from typing import List

class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        board = [[0 for _ in range(3)] for _ in range(3)]
        player = 1

        for move in moves:
            x, y = move
            board[x][y] = player
            player *= -1
        
        for row in range(3):
            sums = sum(board[row])

            if abs(sums) == 3:
                return self.whosWinner(board, row, 0)
            
            sums = 0
            for col in range(3):
                sums += board[col][row]    # row -> col역할임(naming 흠...)

            if abs(sums) == 3:
                return self.whosWinner(board, 0, row)
            
        sums = board[0][0] + board[1][1] + board[2][2]
        if abs(sums) == 3:
            return self.whosWinner(board, 1, 1)

        sums = board[0][2] + board[1][1] + board[2][0]
        if abs(sums) == 3:
            return self.whosWinner(board, 1, 1)
            
        return "Draw" if len(moves) == 9 else "Pending"
            
    def whosWinner(self, board: List, x: int, y: int) -> str:
        return "A" if board[x][y] > 0 else "B"
    
# =============== sol 2 ===============
"""
# Author    : Lee In Bok 
# Date      : 2023.11.01(Wed)
# Spend Time: 미측정
# Runtime   : 40 ms (Beats 60.16%)
# Memory    : 16.1 MB (Beats 85.68%)
# Algoritm  : ???
"""

from typing import List

class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        board = [["" for _ in range(3)] for _ in range(3)]
        turnA = True
        
        for idx in range(len(moves)):
            x, y = moves[idx][0], moves[idx][1]

            board[x][y] = "X" if turnA else "O"
            turnA = not turnA

        winner = self.check(board)

        if winner == "X":
            return "A"
        elif winner == "O":
            return "B"
        
        if winner == None:
            return "Draw" if len(moves) == 9 else "Pending"

        return winner
    
    def check(self, board) -> str:
        if board[0][0] != "" and board[0][0] == board[1][1] == board[2][2]:
            return board[0][0]
        
        if board[2][0] != "" and board[2][0] == board[1][1] == board[0][2]:
            return board[2][0]

        for idx in range(3):
            if board[idx][0] != "" and board[idx][0] == board[idx][1] == board[idx][2]:
                return board[idx][0]
            elif board[0][idx] != "" and board[0][idx] == board[1][idx] == board[2][idx]:
                return board[0][idx]
            
        return None

s = Solution()
result = s.tictactoe([[2,1],[2,0],[2,2],[1,1],[0,0],[0,1],[0,2],[1,0],[1,2]])

print(result)