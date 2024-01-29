# class Solution:
#     def addOperators(self, num: str, target: int) -> list[str]:
#         self.arr = list(map(int, num))
#         self.target = target
#         self.ans = []

#         self.backtracking(1, str(self.arr[0]))

#         return self.ans

#     def backtracking(self, idx:int, expr:str):
#         if idx == len(self.arr):
#             if eval(expr) == self.target:
#                 print(expr, "sum ===> ", eval(expr))
#                 self.ans.append(expr)
#             return
        
#         next_num = self.arr[idx]

#         self.backtracking(idx + 1, expr + '*' + str(next_num))
#         self.backtracking(idx + 1, expr + '+' + str(next_num))
#         self.backtracking(idx + 1, expr + '-' + str(next_num))

#         if expr[-1] != "0":
#             self.backtracking(idx + 1, expr+""+str(next_num))

# import re

# class Solution:
#     def addOperators(self, num: str, target: int) -> list[str]:
#         self.arr = list(map(int, num))
#         self.target = target
#         self.ans = []

#         self.backtracking(1, str(self.arr[0]))

#         return self.ans

#     def backtracking(self, idx:int, expr:str):
#         if idx == len(self.arr):
#             tokens = re.split(r'([-+*])', expr)
#             expr = ""

#             for token in tokens:
#                 if token.isdigit():
#                     if len(token) > 1 and token.startswith("0"):
#                         return

#                     expr += str(int(token))
#                 else:
#                     expr += token
            
#             if eval(expr) == self.target:
#                 self.ans.append(expr)
#             return
        
#         next_num = self.arr[idx]

#         self.backtracking(idx + 1, expr + '*' + str(next_num))
#         self.backtracking(idx + 1, expr + '+' + str(next_num))
#         self.backtracking(idx + 1, expr + '-' + str(next_num))
#         self.backtracking(idx + 1, expr + "" + str(next_num))

class Solution:
    def addOperators(self, num: str, target: int) -> list[str]:
        self.arr = list(map(int, num))
        self.target = target
        self.ans = []

        self.backtracking(1, str(self.arr[0]))

        return self.ans

    def backtracking(self, idx:int, expr:str):
        if idx == len(self.arr):
            if eval(expr) == self.target:
                self.ans.append(expr)
            return
        
        next_num = self.arr[idx]

        for op in ['*', '+', '-']:
            self.backtracking(idx + 1, expr + op + str(next_num))

        first_idx = -1

        while len(expr) >= -first_idx and  expr[first_idx].isdigit():
            first_idx -= 1

        if expr[first_idx + 1] != "0":
            self.backtracking(idx + 1, expr + "" + str(next_num))

s = Solution()
result = s.addOperators("10009", 9)

print(result)