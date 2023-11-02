class Solution:
    answer = []
    opt = ["(", ")"]

    def generateParenthesis(self, n: int) -> list[str]:
        self.generate(n, "")
        print(self.answer)

    def generate(self, n: int, s: str) -> str:
        if len(s) / 2 == n:
            if self.isValid(s):
                self.answer.append(s)
            return
        
        for idx in range(2):
            self.generate(n, s + self.opt[idx])

    def isValid(self, s: str) -> bool:
        stack = []

        for word in s:
            if stack and (word == ")" and stack[-1] == "("):
                del stack[-1]
                continue
        
            stack.append(word)

        return len(stack) == 0

s = Solution()
s.generateParenthesis(2)