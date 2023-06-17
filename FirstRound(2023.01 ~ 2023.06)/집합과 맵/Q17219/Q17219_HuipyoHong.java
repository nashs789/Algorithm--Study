/**
 *  [ 효율성 ]
 *  - 메모리: 145900KB
 *  - 시간 : 1896ms
 */

package BaekJoon.SetAndMap.Q17219;

import java.util.*;

public class Q17219_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<String, String> map = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    put(scanner.next(), scanner.next());
                }
            }
        };

        for (int j = 0; j < m; j++) {
            System.out.println(map.get(scanner.next()));
        }
        scanner.close();
    }
}
