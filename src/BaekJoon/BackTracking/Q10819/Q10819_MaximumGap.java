package BaekJoon.BackTracking.Q10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10819_MaximumGap {

    public static int N;
    public static int max = Integer.MIN_VALUE;
    public static int[] A;
    public static int[] seq;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        seq = new int[N];
        visited = new boolean[N];

        backTracking(0);
        System.out.println(max);
    }

    public static void backTracking(int seqIdx){
        if(seqIdx == N){
            max = Math.max(max, getSum());
            return;
        }

        for(int idx = 0; idx < N; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                seq[seqIdx] = A[idx];
                backTracking(seqIdx + 1);
                visited[idx] = false;
            }
        }
    }

    public static int getSum(){
        int sum = 0;

        for(int idx = 1; idx < N; idx++){
            sum += Math.abs(seq[idx - 1] - seq[idx]);
        }

        return sum;
    }
}