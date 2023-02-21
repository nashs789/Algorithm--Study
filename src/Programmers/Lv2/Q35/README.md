# **[ 정보 ]**
1. 소요 시간: 약 2시간
    - 효율성 테스트: 시간초과 3개의 케이스 발생
2. 날짜: 2023.02.21(화)
3. 저자: 이 인복
4. 난이도: Programmers(Lv2)
5. 분류: 해시   
6. 문제: 전화번호 목록

# **[ 문제 설명 ]**
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.   
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.   
- 구조대 : 119
- 박준영 : 97 674 223
- 지영석 : 11 9552 4421

전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를  
그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

# **[ 제한사항 ]**
- phone_book의 길이는 1 이상 1,000,000 이하입니다.
    - 각 전화번호의 길이는 1 이상 20 이하입니다.
    - 같은 전화번호가 중복해서 들어있지 않습니다.

# **[ 입출력 예 ]**
    phone_book	                        return
    ["119", "97674223", "1195524421"]	false
    ["123","456","789"]	                true
    ["12","123","1235","567","88"]	        false

# **[ 입출력 예 #1 ]**
앞에서 설명한 예와 같습니다.

# **[ 입출력 예 #2 ]**
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

# **[ 입출력 예 #3 ]**
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

# **[ 접근 순서 ]**

# **[ 문제점 & 주의점 ]**
- 효율성 테스트 시간초과 로직
    - 선형 탐색 시간이 오래 걸림
    - 성공한 로직중에 2중 for 문으로 푼 코드도 있었는데 될 때도 있고, 실패할 때도 있다고함
    - 결론: 새로운 알고리즘 공부를 유도하는 문제로 보임
  

        [ 기존 로직 ]
        public class Q35 {
            public static void main(String[] args) {
                String[] phone_book = {"12", "123", "1235", "567", "88"};
                boolean flag = true;

                Arrays.sort(phone_book, new Comparator<String>(){
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                });
        
                int maxLen = phone_book[0].length();
                Map<Integer, LinkedList<String>> map = new HashMap<>();
        
                for(int i = 0; i < phone_book.length; i++){
                    int len = phone_book[i].length();
        
                    if(map.get(len) == null){
                        map.put(len, new LinkedList<>());
                    }
        
                    map.get(len).add(phone_book[i]);
        
                    for(int j = len + 1; j <= maxLen; j++){
                        LinkedList<String> list = map.get(j);
                        if(list == null){
                            continue;
                        }
        
                        for(String str : list){
                            if(str.startsWith(phone_book[i])){
                                flag = false;
                                break;
                            }
                        }
                    }
        
                    if(!flag){
                        break;
                    }
                }
        
                System.out.println(flag);
            }
        }

# **[ 새로 알게된 사실 ]**
- Trie 라는 트리형 알고리즘을 새로 공부하게 되었다
   - ex) 단어(5개) 예시
       1. kakao
       2. kiss
       3. cat
       4. cap
       5. cocoa
  

                  root
                /      \
               k        c
              / \      / \
             a   i    a   o
            /    |   / \  |
           k     s  t   p c
          /      |        |
         a       s        o
        /                 |
       o                  a

# **[ 결과 ]**
