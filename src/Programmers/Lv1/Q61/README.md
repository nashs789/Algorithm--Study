# **[ 정보 ]**
1. 소요 시간: 15:54 - 16:09 (15분)
2. 날짜: 2023.01.22(일)
3. 저자: 이 인복

# **[ 접근 순서 ]**

# **[ 문제점 ]**
- 대문자랑 소문자 아스키 코드 값 헷갈려서 따로 계산했는데 같이 해도 무방할듯

        [ 초기 코드 ]
        public class Q61_StringReverseOrder {
            public static void main(String[] args) {
                String s = "Zbcdeahefg";
                String answer = "";
        
                List<Character> list1 = new ArrayList<>();
                List<Character> list2 = new ArrayList<>();
        
                for(int idx = 0; idx < s.length(); idx++){
                    char letter = s.charAt(idx);
        
                    if(65 <= letter && letter <= 90){
                        list1.add(letter);
                    } else {
                        list2.add(letter);
                    }
                }
        
                answer += list2.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
                answer += list1.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
        
                System.out.println("answer = " + answer);
            }
        }

- 다른 사람 풀이보고 수정한 코드 

        [ 수정 코드 ]
        public class Q61_StringReverseOrder {
            public static void main(String[] args) {
                String s = "Zbcdeahefg";
                String answer = "";
            
                answer = Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        
                System.out.println("answer = " + answer);
            }
        }
# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**       
<img width="464" alt="스크린샷 2023-01-22 오후 4 20 27" src="https://user-images.githubusercontent.com/59809278/213905129-4a1044dc-0f7d-41bf-9c00-63ee2eb0b71b.png">
