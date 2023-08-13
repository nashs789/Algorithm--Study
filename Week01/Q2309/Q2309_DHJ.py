dwarves = []
for _ in range(9):
    height = int(input())
    dwarves.append(height)

def combinations(arr, n):
    result = []
    def backtrack(start, curr_combination):
        if len(curr_combination) == n:
            result.append(curr_combination[:])
            return
        for i in range(start, len(arr)):
            curr_combination.append(arr[i])
            backtrack(i + 1, curr_combination)
            curr_combination.pop()
    
    backtrack(0, [])
    return result

maybe_list = combinations(dwarves, 7)

for i in maybe_list:
    if sum(i) == 100:
        for j in i:
            print(j)
        break
    break

#list 내 요소의 합 구하기: sum_list = sum(list)
#9C7 조합으로 임의의 난쟁이 7명을 뽑고 maybe_list.append()
#if sum(maybe_list) == 100:
# return maybe_list

#for i in maybe_list
# print(i) 