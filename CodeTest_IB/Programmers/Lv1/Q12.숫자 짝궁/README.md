# **[ 정보 ]**
1. 소요 시간: 60분 초과
2. 날짜: 2023.01.04(수)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 공통되는 숫자 찾기
- 형변환을 할지 말지... (String, Integer)

2. 가장 큰 수 조합하기
- 타입에 따라서 방법이 달라짐


# **[ 문제점 ]**
- 1차: 14 / 19 ===> 실패: 0개 / 시간초과: 5개
  
      for(int idx = 0; idx < xLen; idx++){
          String curLetter = X.substring(idx, idx + 1);

          if(Y.indexOf(curLetter) != -1){
              Y = Y.replaceFirst(curLetter,"");
              commonList.add(curLetter);
          }
      }

      answer = commonList.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
      System.out.println(answer.equals("") ? "-1" : (answer.charAt(0) == '0' ? "0" : answer));

- 2차: 0 / 19 ===> 런타임 에러: 19개 / 실패: 0개 / 시간초과: 0개
  
    - 왜 런타임 에러가 날까??? ===> 코드 실행시 테스트 케이스는 실행 되는데, 채점이 안됨 (컴파일러 버전 문제?)  
    - 문제점 ===> xCntArr 배열을 보면 0 ~ 8까지의 숫자만 받도록 되어 있어서 OutOfIndex 에러가 발생했었음
                초기 세팅이 잘못 되었음


  
              public static void main(String[] args) {
                  String X = "100";
                  String Y = "2345";
                  String answer = "";
                  Integer[] xCntArr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
                  Integer[] yCntArr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
          
                  Integer[] xIntArr = getStringArrayToIntegerArr(X);
                  Integer[] yIntArr = getStringArrayToIntegerArr(Y);
                  
                  setCntArr(xIntArr, xCntArr);
                  setCntArr(yIntArr, yCntArr);
          
                  List<Integer> commonList = getCommonNumList(xCntArr, yCntArr);
          
                  answer = commonList.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
                  System.out.println(answer.equals("") ? "-1" : (answer.charAt(0) == '0' ? "0" : answer));
              }
      
              private static List<Integer> getCommonNumList(Integer[] xCntArr, Integer[] yCntArr) {
                    List<Integer> list = new ArrayList<>();
            
                    for(int idx = 0; idx < 9; idx++){
                        int len = xCntArr[idx] <= yCntArr[idx] ? xCntArr[idx] : yCntArr[idx];
            
                        for(int idx2 = 0; idx2 < len; idx2++){
                            list.add(idx);
                        }
                    }
            
                    return list;
              }
            
              private static void setCntArr(Integer[] intArr, Integer[] cntArr) {
                  for(Integer num : intArr){
                      cntArr[num] += 1;
                  }
              }
            
              private static Integer[] getStringArrayToIntegerArr(String strArr){
                  return Stream.of(strArr.split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
              }