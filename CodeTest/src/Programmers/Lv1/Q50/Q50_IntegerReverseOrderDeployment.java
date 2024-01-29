/**
 * [ 문제 설명 ]
 * 함수 solution은 정수 n을 매개변수로 입력받습니다.
 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 *
 * [ 제한 조건 ]
 * n은 1이상 8000000000 이하인 자연수입니다.
 *
 * [ 입출력 예 ]
 * n	    return
 * 118372	873211
 */

package Programmers.Lv1.Q50;

import java.util.Arrays;
import java.util.Comparator;

public class Q50_IntegerReverseOrderDeployment {
    public static void main(String[] args) {
        long n = 118372;
        long answer = 0;
        String[] strArr = (Long.toString(n)).split("");

        Arrays.sort(strArr, Comparator.reverseOrder());

        int multiple = (int)Math.pow(10, strArr.length - 1);

        for(String s : strArr){
            answer += Long.parseLong(s) * multiple;
            multiple /= 10;
        }

        System.out.println("answer = " + answer);
    }
}
//
