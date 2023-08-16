package BaekJoon.BackTracking.Q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663_NQueen {

    public static int N;
    public static int answer = 0;
    public static boolean[] visited1;
    public static boolean[] visited2;
    public static boolean[] visited3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited1 = new boolean[N];
        visited2 = new boolean[(N * 2) - 1];
        visited3 = new boolean[(N * 2) - 1];

        backTracking(0);
        System.out.println(answer);
    }

    static void backTracking(int row){
        if(row == N){
            answer++;
            return;
        }

        for(int idx = 0; idx < N; idx++){
            if(!visited1[idx] && !visited2[row + idx] && !visited3[row - idx + (N - 1)]){
                visited1[idx] = true;
                visited2[row + idx] = true;
                visited3[row - idx + (N - 1)] = true;
                backTracking(row + 1);
                visited1[idx] = false;
                visited2[row + idx] = false;
                visited3[row - idx + (N - 1)] = false;
            }
        }
    }
}