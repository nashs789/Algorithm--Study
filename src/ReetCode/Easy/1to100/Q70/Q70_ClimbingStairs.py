class Solution:
    def climbStairs(self, n: int) -> int:
        fibo = [0 for _ in range(n + 2)]
        fibo[1] = 1

        for idx in range(2, n + 2):
            fibo[idx] = fibo[idx - 2] + fibo[idx - 1]

        return fibo[n + 1]

s = Solution()
result = s.climbStairs(6)

print(result)