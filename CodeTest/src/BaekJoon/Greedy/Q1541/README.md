# **[ 정보 ]**
1. 소요 시간: 42분
2. 날짜: 2023.01.26(목)
3. 저자: 이 인복

# **[ 신경 썼던 케이스 ]**
- 음수가 여러개 나오는 경우 어떻게 처리하는가?
- 괄호를 어떻게 해야 음수가 되고, 양수가 되는가?
- 첫 수가 음수인 케이스 (가장 처음과 마지막 글자는 숫자라고 했으니 음수 배제)

- 풀이: 음수가 나온 순간부터 모든 수는 음수로 간주

# **[ 접근 순서 ]**
**1. 연산자와 피연산자를 분리**
- 문자열에서 '-' 와 '+'가 제외된 문자열(피연산자)
- 문자열에서 0 ~ 9가 제외된 문자열(연산자)

**2. 음수 등장 시점부터 플래그 동작**

**3. 나머지 수 가산(감산)**

# **[ 문제점 ]**

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
![KakaoTalk_Photo_2023-01-26-22-47-15](https://user-images.githubusercontent.com/59809278/214852620-9741b38e-afbb-46ff-8f47-ca0067e5335e.png)