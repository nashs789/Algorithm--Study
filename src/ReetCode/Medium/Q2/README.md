# **[ 정보 ]**
1. 소요 시간: 60 분 초과 (현재 80분째)
2. 날짜: 2023.01.09(월) 아직 풀지 못했다...
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. ListNode 에 대한 파악

2. ListNode 에서 값을 방법 구상

3. ListNode 로 부터 얻은 두 값에 대한 연산과 결과 도출

4. 로직에 대한 생각... 숫자로 연산하는게 아니라 문자로 연산 하는 로직 구현 고...(싹 갈아엎기)

# **[ 구현 순서 ]**
1. getNumber 메소드 구현

2. 덧셈 결과 도출하는 로직 구현

# **[ 문제점 ]**
1. 자리수가 많은 수에 대한 연산이 진행되지 않음
    - 오류 내용: NumberFormatException: For input string: "9999999991"
    - 조치 사항: 타입 변경 int -> BigInteger 로 변경
    - 결과: 같은 내용이지만 더 큰 자릿수 오류 발생

2. 자리수가 많은 수에 대한 연산이 진행되지 않음
    - 오류 내용: NumberFormatException: For input string: "1000000000000000000000000000001"
    - 조치 사항: 타입 변경 BigInteger -> BigDecimal 로 변경
    - 결과: 같은 내용의 오류 유지
   

      [ 초기 숫자 연산을 통한 답안 ]
      import java.math.BigDecimal;
      
      class Solution {
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      BigDecimal sum = new BigDecimal(String.valueOf(getNumber(l1))).add(new BigDecimal(String.valueOf(getNumber(l2))));
      StringBuilder sb = new StringBuilder(sum.toString());
      ListNode answer = new ListNode();
      ListNode answerFirstAddress = answer;
      
              sb.reverse();
              
              for(int idx = 0; idx < sb.length(); idx++){
                  answer.val = (sb.charAt(idx) - 48);
                  if(idx != sb.length() - 1){
                      answer.next = new ListNode();   
                  }
                  answer = answer.next;
              }
      
              answer = answerFirstAddress;
      
              return answer;
          }
      
      public static BigDecimal getNumber(ListNode listNode){
      StringBuilder sb = new StringBuilder();
      
              while(true){
                  sb.append(listNode.val);
      
                  if(listNode.next == null){
                      break;
                  }
      
                  listNode = listNode.next;
              }
      
              return BigDecimal.valueOf(Long.parseLong(sb.reverse().toString()));
          }
      }