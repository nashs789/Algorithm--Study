from collections import deque

class Solution:
    def calcEquation(self, equations: list[list[str]], values: list[float], queries: list[list[str]]) -> list[float]:
        graph = {}

        for idx, pair in enumerate(equations):
            x, y = pair[0], pair[1]

            if y not in graph:
                graph[y] = {}
                
            if x not in graph:
                graph[x] = {}

            graph[y][x] = values[idx]
            graph[x][y] = 1 / values[idx]

        return [self.dfs(graph, x, y) for x, y in queries]

    def dfs(self, graph:dict, des: str, srt:str)-> float:
        if srt not in graph:
            return -1.0

        visited = set()
        queue = deque([(srt, 1)])

        while queue:
            cur_node, cur_val = queue.popleft()

            if des == cur_node:
                return cur_val
            
            if cur_node in graph:
                for key in graph[cur_node].keys():
                    if key not in visited:
                        visited.add(cur_node)
                        queue.append((key, cur_val * graph[cur_node][key]))
        return -1.0

s = Solution()
result = s.calcEquation(
      [["a", "b"],["b", "c"]]  # equations
    , [2.0, 3.0] # values
    , [["a", "c"],["b", "a"],["a", "e"],["a", "a"],["x", "x"]]  # queries
)

print(result)