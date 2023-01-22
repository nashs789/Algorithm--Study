/**
 * [ 문제 설명 ]
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 *
 * [ 제제사항 ]
 * - s는 길이가 1 이상, 100이하인 스트링입니다.
 *
 * [ 입출력 예 ]
 * s	    return
 * "abcde"	"c"
 * "qwer"	"we"
 */

package Programmers.Lv1.Q67;

public class Q67_GetMiddleLetter {
    public static void main(String[] args) {
        String s = "abcde";
        int len = s.length();
        int halfLen = s.length() / 2;

        System.out.println(    len % 2 == 0 ? s.substring(halfLen - 1, halfLen + 1) : s.substring(halfLen, halfLen + 1)     );
    }
}