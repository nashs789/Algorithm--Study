nums = [2, 7, 11, 15]
target = 9

# length = len(nums)
# answer = []

# for i in range(length):
#   for j in range(i + 1, length):
#     if nums[i] + nums[j] == target:
#       answer.append(i)
#       answer.append(j)
#       break

# print(answer)


hash = {}

for idx in range(len(nums)):
    num = target - nums[idx]

    if num in hash:
        print([hash[num], idx])
    hash[nums[idx]] = idx