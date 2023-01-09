/**
 * [ 문제 설명 ]
 * 두 정수 left와 right가 매개변수로 주어집니다.
 * left부터 right까지의 모든 수들 중에서,
 * 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * [ 제한사항 ]
 * 1 ≤ left ≤ right ≤ 1,000
 *
 * [ 입출력 예 ]
 * left	right	result
 * 13	17	    43
 * 24	27	    52
 *
 * [ 입출력 예 #1 ]
 *
 * 다음 표는 13부터 17까지의 수들의 약수를 모두 나타낸 것입니다.
 * 수	약수	            약수의 개수
 * 13	1, 13	            2
 * 14	1, 2, 7, 14	        4
 * 15	1, 3, 5, 15	        4
 * 16	1, 2, 4, 8, 16	    5
 * 17	1, 17	            2
 * 따라서, 13 + 14 + 15 - 16 + 17 = 43을 return 해야 합니다.
 *
 * [ 입출력 예 #2 ]
 *
 * 다음 표는 24부터 27까지의 수들의 약수를 모두 나타낸 것입니다.
 * 수	약수	약수의 개수
 * 24	1, 2, 3, 4, 6, 8, 12, 24	8
 * 25	1, 5, 25	3
 * 26	1, 2, 13, 26	4
 * 27	1, 3, 9, 27	4
 * 따라서, 24 - 25 + 26 + 27 = 52를 return 해야 합니다.
 */

package Programmers.Lv1.Q20;

import java.util.HashSet;
import java.util.Set;

public class Q20_CountOfDivisorAndAddition {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        Set<Integer> divisorSet = new HashSet<>();
        int answer = 0;

        for(int idx = left; idx <= right; idx++){
            int sqrt = (int)Math.sqrt(idx);

            for(int idx2 = 1; idx2 <= sqrt; idx2++){
                if(idx % idx2 == 0){
                    divisorSet.add(idx2);
                    divisorSet.add(idx / idx2);
                }
            }

            if(divisorSet.size() % 2 == 0){
                answer += idx;
            } else {
                answer -= idx;
            }
            divisorSet.clear();
        }

        System.out.println("answer = " + answer);
    }
}
