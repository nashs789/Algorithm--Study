import sys
from collections import deque

class Solution:
    def __init__(self, N:int, L:int, queue: deque) -> None:
        self.N = N
        self.L = L
        self.queue = queue
        
    def sol(self, List:list[int]) -> None:
        for idx, num in enumerate(List):
            while self.queue and self.queue[-1][1] > num:
                self.queue.pop()

            self.queue.append((idx, num))

            while self.queue and self.queue[0][0] <= idx - L:
                self.queue.popleft()

            print(self.queue[0][1], end=" ")

input = sys.stdin.readline
N, L = map(int, input().split())
queue = deque()
List = list(map(int, input().split()))

s = Solution(N, L, queue)
s.sol(List)

'''
12 3
1 5 2 3 6 2 3 7 3 5 2 6
'''