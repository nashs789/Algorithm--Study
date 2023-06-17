/**
 *  [ 효율성 ]
 *  - 메모리: 331844KB
 *  - 시간 : 2416ms
 */

package BaekJoon.SetAndMap.Q1620;

import java.util.*;

public class Q1620_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] totalCount = scanner.nextLine().split(" ");
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= Integer.parseInt(totalCount[0]); i++) {
            String input = scanner.nextLine();

            map1.put(i, input);
            map2.put(input, i);
        }
        for (int j = 0; j < Integer.parseInt(totalCount[1]); j++) {
            String input = scanner.nextLine();

            if (Character.isDigit(input.charAt(0))) {
                System.out.println(map1.get(Integer.parseInt(input)));
            } else {
                System.out.println(map2.get(input));
            }
        }
        scanner.close();
    }
}
