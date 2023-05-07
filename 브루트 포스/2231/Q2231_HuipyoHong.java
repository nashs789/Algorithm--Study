/**
 * [ 접근 순서 ]
 * 1. 브루트포스단원이기때문에 효율성은 생각하지 않는다
 *
 * 2. 0부터 number까지 스트림 생성
 *
 * 3. operand와 operand의 자리수를 더한값이 number가 같지 않을때까지 스트림 생성후 그 스트림의 크기(count)를 구한다.
 * 
 * 4. 구한값과 number가 같으면 0을 출력 아니면 answer을 출력
 *
 *  [ 효율성 ]
 *  - 메모리: 310352KB
 *  - 시간 : 1700ms
 */

package BaekJoon.BruteForce.Q2231;

import java.util.*;
import java.util.stream.*;

public class Q2231_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long answer = IntStream.range(0, number).takeWhile(operand -> operand + Arrays.stream(String.valueOf(operand).split("")).mapToInt(Integer::valueOf).sum() != number).count();

        System.out.println(answer == number ? 0 : answer);
        scanner.close();
    }
}
