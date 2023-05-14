/**
 *  [ 효율성 ]
 *  - 메모리: 357400KB
 *  - 시간 : 2500ms
 */

package BaekJoon.SetAndMap.Q10816;

import java.util.*;

public class Q10816_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    int num = scanner.nextInt();

                    put(num, get(num) != null ? get(num) + 1 : 1);
                }
            }
        };
        int m = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < m; j++) {
            stringBuilder.append(map.getOrDefault(scanner.nextInt(), 0));
            if (j < m - 1) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
        scanner.close();
    }
}
