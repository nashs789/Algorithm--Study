from collections import deque

class Solution:
    def canFinish(self, n: int, prerequisites: list[list[int]]) -> bool:
        graph = [[] for _ in range(n)]
        indegree = [0 for _ in range(n)]
        queue = deque()

        for pairs in prerequisites:
            x, y = pairs[0], pairs[1]

            graph[y].append(x)
            indegree[x] += 1

        for idx, degree in enumerate(indegree):
            if degree == 0:
                queue.append(idx)

        result = self.topology_sort(queue, indegree, graph)

        return result >= n

    def topology_sort(self, queue: deque, indegree: list[int], graph: list[list[int]]) -> int:
        result = 0

        while queue:
            cur_node = queue.popleft()

            if indegree[cur_node] == 0:
                result += 1        

            for linked_node in graph[cur_node]:
                indegree[linked_node] -= 1

                if indegree[linked_node] == 0:
                    queue.append(linked_node)

        return result

s = Solution()
result = s.canFinish(2, [[1,0]])

print(result)