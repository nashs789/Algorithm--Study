/**
 * [ 문제 설명 ]
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 *
 * [ 제한 조건 ]
 * n은 2이상 1000000이하의 자연수입니다.
 *
 * [ 입출력 예 ]
 * n	result
 * 10	4
 * 5	3
 *
 * [ 입출력 예 #1 ]
 * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
 *
 * [ 입출력 예 #2 ]
 * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
 */

package Programmers.Lv1.Q58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q58_PrimeNumber {
    public static void main(String[] args) {
        int n = 10;

        /*if(n == 2) {
            return 1;
        }*/

        List<Integer> primeNumber = new ArrayList(Arrays.asList(new Integer[]{2, 3}));

        for (int idx = 5; idx <= n; idx += 2) {
            boolean isPrime = false;

            for (int idx2 = 1; primeNumber.get(idx2) * primeNumber.get(idx2) <= idx; idx2++) {
                if (idx % primeNumber.get(idx2) == 0) {
                    isPrime = true;
                    break;
                }
            }

            if (!isPrime) {
                primeNumber.add(idx);
            }
        }

        System.out.println("answer = " + primeNumber.size());
    }
}
