"""
# Author    : Lee In Bok 
# Date      : 2023.12.29(Fri)
# Spend Time: 47m 48s
# Runtime   : 44 ms
# Memory    : 31120 KB
# Algoritm  : Stack
"""

import sys
s = sys.stdin.readline().replace('()', '2').replace('[]', '3').strip('\n')

ans = 0
mul = 1
stack = []

for ch in s:
  if ch == '(':
    mul *= 2
  elif ch == ')':
    mul /= 2
  elif ch == '[':
    mul *= 3
  elif ch == ']':
    mul /= 3

  if stack:
    if ch == ')' and stack[-1] == '(':
      stack.pop()
      continue
    elif ch == ']' and stack[-1] == '[':
      stack.pop()
      continue
  
  if not ch.isdigit():
    stack.append(ch)
  else:
    ans += mul * int(ch)
  
if stack:
  print(0)
else:  
  print(int(ans))