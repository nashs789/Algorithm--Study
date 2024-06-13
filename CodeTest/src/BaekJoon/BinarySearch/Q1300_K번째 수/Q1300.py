N = int(input())
K = int(input())

ans, l, r = 0, 1, K

while l <= r:
  mid = (l + r) // 2
  lower_cnt = 0

  for num in range(1, N + 1):
    val = mid // num
    lower_cnt += N if val > N else val

  if lower_cnt < K:
    l = mid + 1
  else:
    ans = mid
    r = mid - 1

print(ans)