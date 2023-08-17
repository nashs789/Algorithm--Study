import sys

def get_next_locations(loc:int) -> list:
    return [loc * 2, loc + 1, loc - 1]
    

def BFS():
    queue = []
    visited = [False] * 100001
    cost = [sys.maxsize] * 100001
    is_end = False
    end_time = 0
    ways = 0
    
    queue.append((N, 0))    # 현 위치, 경과 시간
    visited[0] = True

    while len(queue) > 0:
        cur_loc = queue.pop(0)
        next_locs = get_next_locations(cur_loc[0])

        if cur_loc[0] == K:
            if not is_end:
                is_end = True
                end_time = cur_loc[1]
            ways += 1

        if is_end and end_time < cur_loc[1]:
            break

        for loc in next_locs:
            if 0 <= loc <= 100000 and (not visited[loc] or cost[loc] > cur_loc[1]):
                visited[loc] = True
                cost[loc] = cur_loc[1] + 1
                queue.append((loc, cur_loc[1] + 1))
    print(end_time)
    print(ways)

                            
if __name__ == "__main__":
    N, K = map(int, sys.stdin.readline().split())

    BFS()