/**
 *  [ 효율성 ]
 *  - 메모리: 23796KB
 *  - 시간 : 288ms
 */

package Baekjoon.Q2559;

import java.util.*;
import java.io.*;

/**
 * 1. 누적합 배열을 선언하고, 해당 인덱스까지 누적합을 저장합니다.
 * 2. i = k, i < n + 1까지 max와 sum[i] - sum[i - k] 값을 비교해 max값을 갱신합니다.
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = k; i < n + 1; i++) {
            max = Math.max(max, sum[i] - sum[i -k]);
        }
        System.out.println(max);
    }
}
