/**
 *  [ 효율성 ]
 *  - 메모리: 72720KB
 *  - 시간 : 748ms
 */

package BaekJoon.SetAndMap.Q1764;

import java.util.*;

public class Q1764_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Set<String> mutableSet = new HashSet<>() { 
            { 
                for (int i = 0; i < n; i++) add(scanner.next()); 
            } 
        };
        List<String> result = new ArrayList<>() {
            {
                for (int j = 0; j < m; j++) {
                    String input = scanner.next();

                    if (mutableSet.contains(input)) add(input);
                }
            }
        };

        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(System.out::println);
        scanner.close();
    }
}
