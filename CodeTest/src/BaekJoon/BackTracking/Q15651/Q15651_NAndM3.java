package BaekJoon.BackTracking.Q15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q15651_NAndM3 {
    public static int N;
    public static int M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = arr[0];
        M = arr[1];
        comb = new int[M];

        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int comIdx){
        for(int idx = 0; idx < N; idx++){
            if(comIdx == M){
                for(int n : comb){
                    sb.append(n).append(' ');
                }
                sb.append('\n');

                return;
            }

            comb[comIdx] = idx + 1;
            backTracking(comIdx + 1);
        }
    }
}