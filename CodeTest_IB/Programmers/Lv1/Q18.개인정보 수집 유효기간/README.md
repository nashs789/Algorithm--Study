# **[ 정보 ]**
1. 소요 시간: 60분 초과
2. 날짜: 2023.01.06(금)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 날짜 차이 구하는 방법 알아보기 LocalDate
   - 밑에 보면 방법 테스트한 코드가 있음

2. privacy 문자열 자르는 방법 생각
   - 날짜와 약관 정보를 다르게 관리해야 할 필요가 있음을 느낌 (약관은 나중에 치환)

3. terms 문자열 자르는 방법 생각
   - 약관 배열을 나중에 privacy 약관에 치환하기 위해서 필 

# **[ 구현 순서 ]**
1. setTermAndMonth 메소드 구현
   - 기간과 약관 문자열을 나눠서 약관에 대한 기간을 보유한 콜렉션 초기화 
   
2. 개인의 시작 날짜와 기간 분리
   - 날짜와 약관을 분리
   - 분리한 약관에 처음 만든 콜렉션에서 기간에 대한 정보를 받아서 치환
   - 날짜를 년, 월, 일로 분리 후 LocalDate 객체 생성
   
3. 생성한 LocalDate 객체 이용
   - 약관에 대한 기간이 적용된 날짜로 오늘 날짜와 비교 후 결과 도출


# **[ 문제점 ]**
- 날짜를 처리하는 로직을 공부는 해봤지만 실제로 로직으로 구현해본적이 없어서 테스트를 진행 했었다.
     
      [ 테스트 한 코드 ]
      LocalDate testDate1 = LocalDate.of(2022, 05, 19);
      LocalDate testDate2 = LocalDate.of(2021, 05, 02);
    
      System.out.println("today = " + testDate1);
      System.out.println("endDate = " + testDate2.plusMonths(6));
    
      System.out.println("after = " + testDate1.isAfter(testDate2.plusMonths(6)));
      System.out.println("before = " + testDate1.isBefore(testDate2.plusMonths(6)));         