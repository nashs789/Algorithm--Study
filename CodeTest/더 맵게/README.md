# **[ 정보 ]**
1. 소요 시간 : 35분
2. 날짜 : 2023.03.11
3. 작성자 : 유재학

# **[ 접근 방법]**
PriorityQueue에 scoville 값을 모두 저장 후 PriorityQueue에  저장된 값을 조회하면서 아래 내용을 적용합니다.

1. PriorityQueue의 size가 1인 경우 스코빌 지수를 K이상으로 만들 수 없어 -1 반환
2. PriorityQueue에 poll한 두 값을 통해 새로운 스코빌 지수를 구한 후 저장
3. answer 값 1 증가

반복문 종료 후 answer을 반환합니다.