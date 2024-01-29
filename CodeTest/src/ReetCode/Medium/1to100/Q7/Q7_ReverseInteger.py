class Solution:
    def reverse(self, x: int) -> int:
        isNeg = True if x < 0 else False
        x *= -1 if isNeg else 1
        rev_list = list(map(str, str(x)))

        x = int(''.join(rev_list[::-1]))
        x *= -1 if isNeg else 1

        if (2 ** 31) - 1 < x or x < -(2**31):
            return 0

        return x 

s = Solution()

print(s.reverse(123))