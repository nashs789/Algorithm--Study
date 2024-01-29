/**
 * [ 문제 설명 ]
 * 문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
 *
 * [ 제한사항 ]
 * - 1 ≤ my_string의 길이 ≤ 1,000
 *
 * [ 입출력 예 ]
 * my_string	return
 * "jaron"	    "noraj"
 * "bread"	    "daerb"
 *
 * [ 입출력 예 #1 ]
 * my_string이 "jaron"이므로 거꾸로 뒤집은 "noraj"를 return합니다.
 *
 * [ 입출력 예 #2 ]
 * my_string이 "bread"이므로 거꾸로 뒤집은 "daerb"를 return합니다.
 */

package Programmers.Lv0.Q23;

public class Q23_ReverseString {
    public static void main(String[] args) {
        String my_string = "jaron";
        String[] str = my_string.split("");
        String answer = "";

        for(int idx = str.length - 1; idx >= 0; idx--){
            answer += str[idx];
        }
    }
}
