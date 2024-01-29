package BaekJoon.DynamicProgramming.Q9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095_Plus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine()) - 1;

            for(int j = 3; j <= N; j++){
                if(dp[j] == 0){
                    dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
                }
            }

            sb.append(dp[N] + "\n");
        }

        System.out.print(sb);
    }
}