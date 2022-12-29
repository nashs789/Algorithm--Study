/**
 * 문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
 * 먼저 첫 글자를 읽습니다.
 * 이 글자를 x라고 합시다.
 * 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다.
 * 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
 * s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다.
 * 남은 부분이 없다면 종료합니다.
 * 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
 * 문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
 *
 * [ 제한사항 ]
 * 1 ≤ s의 길이 ≤ 10,000
 * s는 영어 소문자로만 이루어져 있습니다.
 *
 * [ 입출력 예 ]
 *     s	                   result
 * "banana"	                    3
 * "abracadabra"	            6
 * "aaabbaccccabba"	            3
 *
 * [ 입출력 예 #1 ]
 * s="banana"인 경우 ba - na - na와 같이 분해됩니다.
 *
 * [ 입출력 예 #2 ]
 * s="abracadabra"인 경우 ab - ra - ca - da - br - a와 같이 분해됩니다.
 *
 * [ 입출력 예 #3 ]
 * s="aaabbaccccabba"인 경우 aaabbacc - ccab - ba와 같이 분해됩니다.
 */

package Lv1;

import java.util.HashMap;
import java.util.Map;

public class Q3_DivideString {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        int sLength = s.length();

        char first = ' ';
        int firstCnt = 0;
        int secondCnt = 0;
        int result = 0;

        for(int idx = 0; idx < sLength; idx++) {
            char curLetter = s.charAt(idx);

            if(first == ' '){
                first = curLetter;
            }

            if(first == curLetter){
                firstCnt++;
            } else {
                secondCnt++;
            }

            if(firstCnt == secondCnt){
                result++;
                firstCnt = 0;
                secondCnt = 0;
                first = ' ';
            }
        }

        if(firstCnt != 0){
            result++;
        }

        System.out.println("result = " + result);
    }
}

/*public class Q3_DivideString {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        int sLength = s.length();

        Map<Character, Integer> map = new HashMap<>();
        char first = ' ';           // 첫 글자
        char preValue = ' ';        // 이전 글자
        int cnt = 0;                // 첫 글자 연속 갯수
        int result = 0;             // 결과
        boolean diff = false;       // 중간 부터 들어오는 first와 같은 알파벳

        for(int idx = 0; idx < sLength; idx++){
            char curLetter = s.charAt(idx);

            if(first == ' '){
                first = curLetter;
            }

            if(first == curLetter){
                if(!diff){
                    cnt++;
                }
            } else {
                diff = true;
                map.put(curLetter, map.get(curLetter) == null ? 1 : map.get(curLetter)+1);
            }

            if(map.containsValue(cnt) || (first != ' ' && idx == sLength - 1)){
                result++;
                System.out.println("first = " + first + "        cnt = " + cnt);
                System.out.println("map = " + map);
                map.clear();
                first = ' ';
                diff = false;
                cnt = 0;
                if(curLetter == preValue){
                    idx--;
                }
            }

            preValue = curLetter;
        }

        System.out.println("result = " + result);
    }
}*/
