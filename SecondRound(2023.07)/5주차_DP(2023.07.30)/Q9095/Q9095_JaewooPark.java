/**
 *  [ 효율성 ]
 *  - 메모리: 17700KB
 *  - 시간 : 204ms
 */


package Baekjoon.Q9095;

import java.util.*;

public class sum123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        int n = sc.nextInt();
        arr[0] = 1; arr[1] = 2; arr[2] = 4;

        for (int i = 3; i < 11; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            System.out.println(arr[m - 1]);
        }
        sc.close();
    }
}
