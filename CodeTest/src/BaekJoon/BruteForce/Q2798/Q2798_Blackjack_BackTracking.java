package BaekJoon.BruteForce.Q2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2798_Blackjack_BackTracking {

    private static boolean[] visited;
    private static int[] comb = new int[3];
    private static int[] nums;
    private static int max = 0;
    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[N];

        backTracking(0);

        System.out.println(max);
    }

    public static void backTracking(int idx){
        if(idx > 2){
            int sum = Arrays.stream(comb).sum();

            if(max < sum && M >= sum){
                max = sum;
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                comb[idx] = nums[i];
                backTracking(++idx);
                idx--;
                visited[i] = false;
            }
        }
    }
}