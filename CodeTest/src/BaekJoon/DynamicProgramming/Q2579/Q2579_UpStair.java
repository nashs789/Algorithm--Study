package BaekJoon.DynamicProgramming.Q2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579_UpStair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] stairs = new int[T];
        int[] acc = new int[T];

        for (int i = 0; i < T; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        acc[0] = stairs[0];
        acc[1] = stairs[0] + stairs[1];
        acc[2] = Math.max(stairs[0], stairs[1]) + stairs[2];

        for(int i = 3; i < T; i++){
            acc[i] = Math.max(stairs[i - 1] + acc[i - 3], acc[i - 2]) + stairs[i];
        }

        System.out.println(acc[T - 1]);
    }
}