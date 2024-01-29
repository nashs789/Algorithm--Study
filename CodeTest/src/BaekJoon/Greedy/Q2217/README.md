# **[ 정보 ]**
1. 소요 시간: 24분
2. 날짜: 2023.01.27(금)
3. 저자: 이 인복

# **[ 신경 썼던 케이스 ]**
- 문제 설명이 부실 했던것 같음
    - 입력: 3 30 40 50 60 70 80
    - 케이스1-로프1개: 80 ===> 80kg
    - 케이스2-로프2개: 80 70 ===> 140kg
    - 케이스3-로프3개: 80 70 60 ===> 180kg
    - 케이스4-로프4개: 80 70 60 50 ===> 200kg
    - 케이스5-로프5개: 80 70 60 50 40 ===> 200kg
    - 케이스6-로프6개: 80 70 60 50 40 30 ===> 180kg
    
- 설명: 로프가 병렬적으로 연결 된다면 버티는 힘이 가장 약한 무게를 갖는 로프가 마지노선이 된다.
    - ex) 30 40 로프 2개가 있다면 30kg를 초과하게 되는 케이스에 30로프가 끊어지기 때문에 30kg이 마지노선이다.

# **[ 접근 순서 ]**
**1. 로프 정렬**
- 가장 무거운 무게를 버티는 로프를 순서로 무게를 구하기 떄문

**2. 가장 많이 버텨지는 무게 산출**

# **[ 문제점 ]**
- 고려사항(문제점 까지는 아닌듯): 특정 범위에 따라서 무게가 다시 내려가는 시점이 있는데 찾을 수 있다면 여기서
break 문을 사용하면 더 좋을 것 같음

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1142" alt="스크린샷 2023-01-27 오전 12 34 37" src="https://user-images.githubusercontent.com/59809278/214880167-06ac5a03-7ed8-45af-922b-2edad0b542e8.png">




         