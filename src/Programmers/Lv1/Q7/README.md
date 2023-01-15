# **[ 정보 ]**
1. 소요 시간: 10분
2. 날짜: 2023.01.03(화)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 배열에서 어떤 식으로 값을 꺼낼 것인가?
-  정방향 or 역방향 순서

2. 문자열을 어떻게 배치 할 것인가?
- answer 를 만드는 문자열 연산에 대한 고민

# **[ 초기 코드 - 중요 로직(이하 생략) ]**

    String answer = "";
    
    for(int idx = 1; idx < food.length; idx++){
        for(int idx2 = 0; idx2 < food[idx] / 2; idx2++){
            answer += idx;
            reverseOrder = idx + reverseOrder;
        }
    }

# **[ 수정 코드 - 중요 로직(이하 생략) ]**

    String answer = "0";

    for(int idx = food.length - 1; idx > 0; idx--){
        for(int idx2 = 0; idx2 < food[idx] / 2; idx2++){
            answer = idx + answer + idx;
        }
    }
    
# **[ 결과 ]**
<img width="427" alt="스크린샷 2023-01-15 오전 11 26 43" src="https://user-images.githubusercontent.com/59809278/212519801-c0725d06-aed7-4a59-a3fa-48b02572bd28.png">
