/**
 * [ 문제 설명 ]
 * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
 * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 *
 * [ 제한사항 ]
 * 0 <numer1, denom1, numer2, denom2 < 1,000
 *
 * [ 입출력 예 ]
 * numer1	denom1	numer2	denom2	result
 * 1    	2	    3	    4	    [5, 4]
 * 9	    2	    1	    3	    [29, 6]
 *
 * [ 입출력 예 #1 ]
 * 1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.
 *
 * [ 입출력 예 #2 ]
 * 9 / 2 + 1 / 3 = 29 / 6입니다. 따라서 [29, 6]을 return 합니다.
 */

package Programmers.Lv0.Q9;

import java.util.Arrays;

public class Q9_AdditionOfFraction {
    public static void main(String[] args) {
        int numer1 = 5;
        int denom1 = 12;
        int numer2 = 3;
        int denom2 = 4;
        int[] num = {numer1, denom1, numer2, denom2};
        int[] answer = new int[2];

        appliedLcm(num);

        answer[0] = num[0] + num[2];
        answer[1] = num[1];

        appliedGcd(answer);

        Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
    }

    public static void appliedGcd(int[] num){
        int lastIdx = num[0] > num[1] ? num[1] : num[0];

        for(int idx = lastIdx; idx > 0; idx--){
            if(num[0] % idx == 0 && num[1] % idx == 0){
                num[0] /= idx;
                num[1] /= idx;
            }
        }
    }

    public static void appliedLcm(int[] num){
        int[] tempNum = {num[0], num[1], num[2], num[3]};

        while(num[1] != num[3]){
            if(num[1] < num[3]){
                num[0] += tempNum[0];
                num[1] += tempNum[1];
            } else {
                num[2] += tempNum[2];
                num[3] += tempNum[3];
            }
        }
    }
}