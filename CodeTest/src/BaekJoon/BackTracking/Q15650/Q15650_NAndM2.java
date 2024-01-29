package BaekJoon.BackTracking.Q15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q15650_NAndM2 {

    public static int N;
    public static int M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] comb;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = arr[0];
        M = arr[1];
        visited = new boolean[N];
        comb = new int[M];

        backTracking(0,0);
        System.out.println(sb);
    }

    static void backTracking(int numIdx, int comIdx){
        for(int idx = numIdx; idx < N; idx++){
            if(comIdx == M){
                for(int n : comb){
                    sb.append(n).append(' ');
                }
                sb.append('\n');

                return;
            }

            if(!visited[idx]){
                visited[idx] = true;
                comb[comIdx] = idx + 1;
                backTracking(idx, comIdx + 1);
                visited[idx] = false;
            }
        }
    }
}