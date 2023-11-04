import sys
from heapq import heappop, heappush
input = sys.stdin.readline

class Solution():
    def sol(self):
        heap = []

        for _ in range(N):
            num = int(input())

            if num != 0:
                heappush(heap, (abs(num), num))
            else:
                if heap:
                    print(heappop(heap)[1])
                else:
                    print(0)
            

s = Solution()
N = int(input())

s.sol()
