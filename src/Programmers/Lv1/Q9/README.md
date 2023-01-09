# **[ 정보 ]**
1. 소요 시간: 60분 초과
2. 날짜: 2023.01.04(수)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 문자열 내에서 특정 문자열 여부를 어떻게 판단할 것인가?
- 정규식 or 문자열 메소드

2. 연속 발음은 어떻게 제외할 것인가?
- 반복문 내에서 같이 처리
- 모듈화 

     
# **[ 문제점 ]**
- 1차 시도: 11 / 20 ===> 실패: 9개 / 시간초과: 0개
    - 발음이 가능한 단어를 순서대로 replace 시켜서 문자열이 재조합 되면서 발음이 불가능하던 문자들이
      발음이 가능하도록 변경되면서 문제점이 야기됨
      
      ex) wayaoo -> w'aya'oo -> woo -> blank space

            for(int idx = 0; idx < babbling.length; idx++){
                for(int idx2 = 0; idx2 < can.length; idx2++){
                    if(babbling[idx].indexOf(can[idx2]) != -1){
                        babbling[idx] = babbling[idx].replaceFirst(can[idx2], "");
                    }
                 }
      
                if(babbling[idx].equals("")){
                    answer++;
                }
      
- 2차 시도: 15 / 20 ===> 실패: 5개 / 시간초과: 0개
    - 연속되서 나올 수 같은 문자가 나올 수 있는 가능성을 체크하지 않았음 (문제에 명시되어 있음)
    - 같은 문자가 문자열 내에 여러번 있을 수 있지만 replaceFirst 를 사용해서 맨 앞에서 한 번만 문자 체크하면서 
      뒤에 나올 문자들을 배제했음
    - 문자가 여전히 재조합 되는 문제점이 해결이 되지 않음 (1차 시도와 동일한 문제점)
    
            for(int idx = 0; idx < babbling.length; idx++){
                for(int idx2 = 0; idx2 < can.length; idx2++){
                    if(babbling[idx].indexOf(can[idx2]) != -1){
                        removeList.add(idx2);
                    }
                }
    
                for(Integer idx3 : removeList){
                    babbling[idx] = babbling[idx].replaceFirst(can[idx3], "");
                }
                removeList.clear();
    
                if(babbling[idx].equals("")){
                    answer++;
                }
          }