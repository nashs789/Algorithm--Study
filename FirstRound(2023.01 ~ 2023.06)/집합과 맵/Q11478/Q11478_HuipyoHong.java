/**
 *  [ 효율성 ]
 *  - 메모리: 229668KB
 *  - 시간 : 884ms
 */

package BaekJoon.SetAndMap.Q11478;

import java.util.Scanner;
import java.util.stream.*;

public class Q11478_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(IntStream.rangeClosed(0, input.length()).boxed().flatMap(i -> IntStream.rangeClosed(i + 1, input.length()).mapToObj(j -> input.substring(i, j))).collect(Collectors.toSet()).size());
        scanner.close();
    }
}
