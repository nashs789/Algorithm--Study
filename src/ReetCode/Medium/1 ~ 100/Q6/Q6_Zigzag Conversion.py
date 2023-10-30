"""
# Author    : Lee In Bok 
# Date      : 2023.10.31(Tue)
# Spend Time: 31m 19s
# Runtime   : 434 ms (Beats 9.40%)
# Memory    : 20.2 MB (Beats 7.56%)
# Algoritm  : String
"""

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        arr = [["" for _ in range(len(s) // 2 + 1)] for _ in range(numRows + 1)]
        x, y = 0, 0
        pattern = True

        for ch in s:
            arr[x][y] = ch

            if pattern:
                x += 1
            else:
                x -= 1
                y += 1

            if x == numRows -1:
                pattern = False
            elif x == 0:
                pattern = True

        ans = ""

        for a in arr:
            for b in a:
                ans += b

        return ans

"""
# Author    : Someone in LeetCode
# Date      : 2023.10.31(Tue)
# Spend Time: (X)
# Runtime   : 50 ms (Beats 91.31%)
# Memory    : 16.3 MB (Beats 86.43%)
# Algoritm  : Copy
"""
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        
        row_arr = [""] * numRows
        idx, up = 0, True

        for ch in s:
            row_arr[idx] += ch

            if idx == numRows - 1:
                up = False
            elif idx == 0:
                up = True

            idx += 1 if up else -1

        return "".join(row_arr)
        
s = Solution()
result = s.convert("PAYPALISHIRING", 4)

print(result)