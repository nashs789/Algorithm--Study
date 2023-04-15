/**
 * [ 접근 순서 ]
 * 1. 브루트포스단원이기때문에 효율성은 생각하지 않는다
 *
 * 2. 0부터 input까지 5씩 증가하는 스트림 생성
 *
 * 3. 0부터 input까지 3씩 증가하는 스트림 생성
 *
 * 4. 5씩 증가하는 스트림의 인자와 3씩 증가하는 스트림의 인자의 합이 input과 같은것만 필터 후 나누기 합 매핑
 * 
 * 4. 펼쳐진 맵의 마지막값만 추출, 없는경우 기본값 -1을 출력
 *
 *  [ 효율성 ]
 *  - 메모리: 19244KB
 *  - 시간 : 336ms
 */

package BaekJoon.BruteForce.Q2839;

import java.util.*;
import java.util.stream.*;

public class Q2839_HongHuipyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(IntStream.iterate(0, i -> i <= input, i -> i + 5).flatMap(i -> IntStream.iterate(0, j -> j <= input, j -> j + 3).takeWhile(j -> i + j <= input).filter(j -> i + j == input).map(j -> i / 5 + j / 3)).boxed().reduce(-1, (acc, i) -> i));
        scanner.close();
    }
}
