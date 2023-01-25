/**
 * [ 문제 설명 ]
 * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
 *
 * [ 제한사항 ]
 * - 1 ≤ n ≤ 100
 *
 * [ 입출력 예 ]
 * n	result
 * 10	[1, 3, 5, 7, 9]
 * 15	[1, 3, 5, 7, 9, 11, 13, 15]
 *
 * [ 입출력 #1 ]
 * 10 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9]를 return합니다.
 *
 * [ 입출력 #1 ]
 * 15 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9, 11, 13, 15]를 return합니다.
 */

package Programmers.Lv0.Q14;

import java.util.Arrays;

public class Q14_HateEvenNumber {
    public static void main(String[] args) {
        int n = 15;
        int arrayIdx = 0;
        int[] answer = new int[n % 2 == 0 ? n / 2 : (n / 2) + 1];

        for(int idx = 1; idx <= n; idx+=2){
            answer[arrayIdx++] = idx;
        }

        Arrays.stream(answer).forEach(System.out::print);
    }
}