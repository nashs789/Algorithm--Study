# class Solution:
#     def trap(self, heights: list[int]) -> int:
#         stack = []
#         traped, start, area = 0, 0, 0
        
#         for height in heights:
#             if start == 0:
#                 start = height
#             elif start <= height:
#                 traped += len(stack) * start - area + (-1 if start == 1 else 0)  # start가 1이면 계산이 미스나서 넣었음
#                 start = height
#                 stack = []
#                 area = 0

#             area += height
#             stack.append(height)
        
#         if len(stack) > 1:
#             start = stack[0]

#             for height in stack:
#                 if height == start:
#                     del stack[0]
#                 else:
#                     break

#         return traped

# s = Solution()
# result = s.trap([0,1,0,2,1,0,1,3,2,1,2,1])

# print(result)

class Solution:
    def trap(self, height: list[int]) -> int:
        if not height:
            return 0
        
        res = 0
        l, r = 0, len(height) - 1
        leftMax, rightMax = height[l], height[r]
        
        while l < r:
            if leftMax <= rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]  
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
                
        return res

s = Solution()
result = s.trap([0,1,0,2,1,0,1,3,2,1,2,1])

print(result)