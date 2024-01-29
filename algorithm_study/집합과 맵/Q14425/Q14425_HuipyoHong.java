/**
 *  [ 효율성 ]
 *  - 메모리: 68824KB
 *  - 시간 : 1096ms
 */

package BaekJoon.SetAndMap.Q14425;

import java.util.*;

public class Q14425_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int answer = 0;
        Set<String> set = new HashSet<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(scanner.next());
                }
            }
        };

        for (int j = 0; j < m; j++) {
            if (set.contains(scanner.next())) {
                answer++;
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
