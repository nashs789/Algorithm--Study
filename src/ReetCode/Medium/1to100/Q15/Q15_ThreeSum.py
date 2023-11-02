nums = [-1, 0, 1, 2, -1, -4]

# 6 Failed (Time Limit Exceeded)
# Set = set()
# answer = []

# for i in range(len(nums)):
#     for j in range(i + 1, len(nums)):
#         for k in range(j + 1, len(nums)):
#             if(nums[i] + nums[j] + nums[k] == 0):
#                 List = [nums[i], nums[j], nums[k]]
#                 Set.add(tuple(sorted(List)))

# for num_list in Set:
#     answer.append(list(num_list))

# print(answer)

answer = []
nums.sort()
length = len(nums)

for i in range(length):
    left = i + 1
    right = length - 1

    while left < right:
        sum = nums[i] + nums[left] + nums[right]

        if sum == 0:
            answer.append([nums[i], nums[right], nums[left]])
            right -= 1
            left += 1
        elif sum > 0:
            right -= 1
        else :
            left += 1

print(answer)