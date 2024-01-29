### 에라토네스의 채 - 메모리 초과
# import math

# N = int(input())
# M = pow(10, N)
# K = pow(10, N - 1)
# prime = [True] * M
# prime[0] = False
# prime[1] = False

# for num in range(2, M):
#   # 소수가 아니면 패스
#   if not prime[num]:
#     continue

#   # ex) num이 5라면 2 ~ 4까지 나눠서 소수인지 확인
#   for idx in range(2, int(math.sqrt(num)) + 1):
#     if num % idx == 0:
#       prime[num] = False

#   if prime[num]:
#     # 에라토네스의 체
#     tmp = num * 2 
#     while tmp < M:
#       prime[tmp] = False
#       tmp += num

# for num in range(len(prime)):
#   if prime[num] and K <= num < M:
#     tmp = K
#     ans = True
    
#     while tmp != 1:
#       if not prime[num // tmp]:
#         ans = False
      
#       tmp //= 10

#     if ans:
#       print(num)

import math

N = int(input())

def dfs(n):
  if len(str(n)) == N:
    print(n)
  
  for add in range(1, 10, 2):
    tmp = n * 10 + add

    if is_prime(tmp):
      dfs(tmp)

def is_prime(n):
  for idx in range(2, int(math.sqrt(n)) + 1):
    if n % idx == 0:
      return False
  return True

dfs(2)
dfs(3)
dfs(5)
dfs(7)