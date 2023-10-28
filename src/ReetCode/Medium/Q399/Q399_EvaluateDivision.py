class Solution:
    def calcEquation(self, equations: list[list[str]], values: list[float], queries: list[list[str]]) -> list[float]:
        pass

s = Solution()
result = s.calcEquation(
      [["a", "b"],["b", "c"]]  # equations
    , [2.0, 3.0] # values
    , [["a", "c"],["b", "a"],["a", "e"],["a", "a"],["x", "x"]]  # queries
)

print(result)