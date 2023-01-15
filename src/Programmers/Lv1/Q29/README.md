# **[ 정보 ]**
1. 소요 시간: 08:40 - 09:33 (53분) 
2. 날짜: 2023.01.15(일)
3. 저자: 이 인복

# **[ 접근 순서 ]**
**1. prefix 구하기**
    - prefix 를 단 한번의 반복으로는 구할 수 없었음

**2. 예외 처리**
    - test case 에서 많은 예외가 발생 되었음

# **[ 문제점 ]**
**1. 첫 번쨰**
- 1차: 49 / 124 ===> input: "a" / output: "" / expected: "a"
  - 1개의 모음만 들어왔을 경우

- 2차: 50 / 124 ===> input: "ab", "a" / output: "" / expected: "a"
  - prefix의 기준을 잘못 잡은 것 같음... 코드 갈아 엎어야 할듯
 
   
    [ 문제의 초기 코드 ]
    public class Q14_LongestCommonPrefix {
      public static void main(String[] args) {
      String[] strs = {"flower", "flow", "flight"};
      // if(strs.length == 1) return "";
    
            String[] vowels = {"a", "e", "i", "o", "u"};
            int min = getMin(strs[0], vowels);
            String prefix = strs[0].substring(0, min);
    
            for(int idx = 0; idx < strs.length; idx++){
                if(!strs[idx].startsWith(prefix)){
                    System.out.println("nothing");
                    // return "";
                }
            }
    
            System.out.println("prefix = " + prefix);
            // return prefix
      }

      private static int getMin(String str, String[] vowels) {
            int min = 201;
    
            for(int idx = 0; idx < vowels.length; idx++){
                int loc = str.indexOf(vowels[idx]);
    
                if(loc != -1 && min > loc){
                    min = loc;
                }
            }
    
            return min == 201 ? 0 : min;
      }
    }

**2. 두 번째**
- 1차: 81 / 124 ===> input: "cir", "car" / output: "" / expected: "c"
  - prefix 초기화 부분 변경 (기존에는 초기 값 설정이 안되는 케이스가 존재 했었음)

- 2차: 121 / 214 ===> input: "reflower", "flow", "flight" / output: "fl" / expected: ""
  - min 값이 고정되어 있는 부분 변경, 재할당이 안되고 있었음 (in = prefix.length(); 이 부분이 없었음)
  - prefix 값 초기화 하는 부분에서 index 값 초기화가 제대로 안되고 있었음 (배열 요소 0번 부터 탐색해야 하는데 1번 부터 했음)

# **[ 새로 알게된 사실 ]**
         