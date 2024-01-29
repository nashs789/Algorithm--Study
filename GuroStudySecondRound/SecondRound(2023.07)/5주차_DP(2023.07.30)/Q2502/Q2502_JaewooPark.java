/**
 *  [ 효율성 ]
 *  - 메모리: 17688KB
 *  - 시간 : 212ms
 */

package Baekjoon.Q2502;

import java.util.*;

public class tigerEating {
    static ArrayList<Integer[]> list;
    static Integer[] answer;
    static boolean checker;
    public static void listInit() {
        list.add(new Integer[2]);
        list.get(0)[0] = 1;
        list.get(0)[1] = 0;
        list.add(new Integer[2]);
        list.get(1)[0] = 0;
        list.get(1)[1] = 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        answer = new Integer[2];
        int d, k;

        d = sc.nextInt();
        k = sc.nextInt();

        listInit();

        for (int i = 2; i < 31; i++) {
            list.add(new Integer[2]);
            list.get(i)[0] = list.get(i - 1)[0] + list.get(i - 2)[0];
            list.get(i)[1] = list.get(i - 1)[1] + list.get(i - 2)[1];
        }

        // d3 = a + b
        // d4 = d3 + b = a + 2b
        // d5 = d4 + d3 = a + b + a + 2b = 2a + 3b
        // d6 = d5 + d4 = 2a + 3b + a + 2b = 3a + 5b
        // d7 = d6 + d5 = 3a + 5b + 2a + 3b = 5a + 8b

        int a = list.get(d - 1)[0];
        int b = list.get(d - 1)[1];

        for (int i = 1; i <= k / a; i++) {
            if (checker) {
                break;
            }
            for (int j = 1; j <= k / b; j++) {
                int sum = a * i + b * j;
                if (sum == k) {
                    answer[0] = i;
                    answer[1] = j;
                    checker = true;
                }
            }
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
