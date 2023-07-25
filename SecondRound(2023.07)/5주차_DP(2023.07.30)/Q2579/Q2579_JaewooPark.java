/**
 *  [ 효율성 ]
 *  - 메모리: 17776KB
 *  - 시간 : 220ms
 */

package Baekjoon.Q2579;

import java.util.Scanner;

public class climbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2]; // n = 1 or 2일 때, Array OutOfIndex -> +2를 해줘야 에러가 안남
        int[] sum = new int[n + 2]; //
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sum[0] = arr[0];
        sum[1] = arr[0] + arr[1];
        sum[2] = Math.max(arr[2] + arr[0], arr[2] + arr[1]);

        for (int i = 3; i < n; i++) {
            sum[i] = Math.max(arr[i] + sum[i - 2], arr[i] + arr[i - 1] + sum[i - 3]);
        }

        System.out.println(sum[n - 1]);
        sc.close();
    }
}
