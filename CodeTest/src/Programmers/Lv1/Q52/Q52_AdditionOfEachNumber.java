/**
 * [ 문제 설명 ]
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * [ 제한사항 ]
 * N의 범위 : 100,000,000 이하의 자연수
 *
 * [ 입출력 예 ]
 * N	    answer
 * 123	    6
 * 987	    24
 *
 * [ 입출력 예 #2 ]
 * 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
 */

package Programmers.Lv1.Q52;

import java.util.Arrays;

public class Q52_AdditionOfEachNumber {
    public static void main(String[] args) {
        int n = 978;

        System.out.println( Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::new).sum() );
    }
}
