/**
 *  [ 효율성 ]
 *  - 메모리: 327404KB
 *  - 시간 : 1860ms
 */

package BaekJoon.SetAndMap.Q1269;

import java.util.*;

public class Q1269_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aCount = scanner.nextInt(), bCount = scanner.nextInt();
        HashSet<Integer> a = new HashSet<>() {
            {
                for (int i = 0; i < aCount; i++) {
                    add(scanner.nextInt());
                }
            }
        };
        HashSet<Integer> b = new HashSet<>() {
            {
                for (int j = 0; j < bCount; j++) {
                    add(scanner.nextInt());
                }
            }
        };

        System.out.println(new HashSet<>(b) { { removeAll(a); } }.size() + new HashSet<>(a) { { removeAll(b); } }.size());
        scanner.close();
    }
}
