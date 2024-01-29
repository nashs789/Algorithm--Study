/**
 * [ 문제 설명 ]
 * 문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.
 *
 * [ 제한사항 ]
 * - 2 ≤ my_string 길이 ≤ 5
 * - 2 ≤ n ≤ 10
 * - "my_string"은 영어 대소문자로 이루어져 있습니다.
 *
 * [ 입출력 예 ]
 * my_string	n	    result
 * "hello"	    3	"hhheeellllllooo"
 *
 * [ 입출력 예 #1 ]
 * "hello"의 각 문자를 세 번씩 반복한 "hhheeellllllooo"를 return 합니다.
 */

package Programmers.Lv0.Q26;

public class Q26_RepeatCharacter {
    public static void main(String[] args) {
        String my_string = "hello";
        int n = 3;
        String answer = "";

        for(int idx1 = 0; idx1 < my_string.length(); idx1++){
            for(int idx2 = 0; idx2 < n; idx2++){
                answer += my_string.charAt(idx1);
            }
        }

        System.out.println("answer = " + answer);
    }
}