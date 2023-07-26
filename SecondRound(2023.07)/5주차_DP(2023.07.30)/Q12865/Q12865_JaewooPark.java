/**
 *  [ 효율성 ]
 *  - 메모리: 53876KB
 *  - 시간 : 192ms
 */


package Baekjoon.Q12865;

import java.io.*;
import java.util.*;

public class backpack {
    static int n, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n + 1];
        int[] price = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        // weight = 6  4 3 5
        // price  = 13 8 6 12

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + price[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        System.out.println(dp[n][k]);

    }
}