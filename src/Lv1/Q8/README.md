# **[ 정보 ]**
1. 소요 시간: 60분 초과
2. 날짜: 2023.01.03(화)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 어떻게 접근할 것인가?
   - 주어진 배열을 어떤 형태로 변경해서 사용할지
     1. int[] 배열을 boxing 후 List 형태로 사용 (x)
     2. int[] 배열을 boxing 후 String 타입으로 변경 후 문자열 메소드를 이용해서 접근 (x)
     3. int[] 배열을 boxing 후 stack 을 이용해서 접근 (o)  
      
  
2. 배열 내에서 어떻게 1, 2, 3 순서대로 뽑지?
   - 배열 내부에서 연속된 숫자 1231에 어떻게 식별 할 것인가에 대해서 생각
   - 1231에 집착하지 않는다면 어떤 식으로 접근할 수 있을지 생각
    

3. 값을 뽑아낸 이후에 배열 재정리는 어떻게?
   - 초기에는 문자열 혹은 리스트를 사용할 예정이라서 1231을 제거하고 콜렉션을 재정비 하는 로직을 생각 했었음  
     ex) 1213'1231'111 -> 1213111
     
# **[ 문제점 ]**

    int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
    Integer[] newIngredient = Arrays.stream(ingredient).boxed().toArray(Integer[]::new);
    List<Integer> list = new ArrayList<>(Arrays.asList(newIngredient));
    int answer = 0;
    int listSize = list.size();

    for(int idx = 0; idx < listSize - 3; idx++){
        if(list.get(idx) == 1){
            if(list.get(idx + 1) == 2){
                if(list.get(idx + 2) == 3){
                    if(list.get(idx + 3) == 1){
                        answer++;
                        list.remove(idx + 3);
                        list.remove(idx + 2);
                        list.remove(idx + 1);
                        list.remove(idx);
                        idx = 0;
                        listSize = list.size();
                    }
                }
            }
        }
    }

- 1차: 10 / 18 === > 시간초과 6개, 실패 2개
    - 로직에 문제가 있다고 판단 후 코드를 새로 짜기로 마음 먹음 
    

          int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
          int answer = 0;

          Integer[] newIngredient = Arrays.stream(ingredient).boxed().toArray(Integer[]::new);
          String strIngredient = Arrays.toString(newIngredient).replaceAll("[, \\[\\]]", "");

          while(strIngredient.indexOf("1231") != -1){
              int locationStr = strIngredient.indexOf("1231");
              strIngredient = strIngredient.substring(0, locationStr) + strIngredient.substring(locationStr + 4);
              answer++;
          }

- 2차: 문자열로 변경 후 16 / 18 => 시간초과 2문제 (테스트5, 12)
    - 추정되는 문제점: 문자열 연산이 빈번하게 일어나서 배열의 길이가 길어지면 시간을 초과 하게됨
