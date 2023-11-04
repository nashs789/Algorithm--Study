"""
# Author    : Lee In Bok 
# Date      : 2023.11.04(Sat)
# Spend Time: 47m 50s
# Runtime   : 37 ms (Beats 81.76%)
# Memory    : 16.2 MB (Beats 81.11%)
# Algoritm  : String
"""

# class Solution:
#     def addBinary(self, a: str, b: str) -> str:
#         return bin(int(a, 2) + int(b, 2))[2:]

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry, result = False, []
        x, y = len(a) - 1, len(b) - 1

        if a == b == "0":
            return "0"

        while 0 <= x and 0 <= y:
            if a[x] == b[y] == "1":
                result.append("1" if carry else "0")
                carry = True
            elif a[x] == b[y] == "0":
                result.append("1" if carry else "0")
                carry = False
            else:
                result.append("0" if carry else "1")
                carry = True if carry else False

            x -= 1
            y -= 1
        
        carry = self.checkRest(a, x, carry, result)
        carry = self.checkRest(b, y, carry, result)

        if result[-1] == "0" or carry:
            result.append("1")

        return ''.join(reversed(result))
    
    def checkRest(self, arr, idx, carry, result):
        while 0 <= idx:
            if arr[idx] == "1":
                result.append("0" if carry else "1")
                carry = True if carry else False
            else:
                result.append("1" if carry else "0")
                carry = False

            idx -= 1

        return carry

s = Solution()
result = s.addBinary("101111", 
                     "10")

print(result)