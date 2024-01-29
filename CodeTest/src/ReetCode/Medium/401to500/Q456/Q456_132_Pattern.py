import sys

class Solution:
    def find132pattern(self, nums: list[int]) -> bool:
        stack, two = [], -sys.maxsize

        for one in reversed(nums):
            print(one)
            print(stack)
            if one < two:
                return True     # We found a 1 that is less than 2.
            while stack and stack[-1] < one:        # stack[-1] = Three
                two = stack.pop()           # 2 should be less than 3.
            stack.append(one)
        
        return False

s = Solution()
result = s.find132pattern([3,1,4,2])