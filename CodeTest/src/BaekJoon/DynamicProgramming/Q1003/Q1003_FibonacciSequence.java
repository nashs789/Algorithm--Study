package BaekJoon.DynamicProgramming.Q1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003_FibonacciSequence {

    public static int[][] count = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;

        for(int i = 0; i < testCase; i++){
            int num = Integer.parseInt(br.readLine());

            for(int j = 2; j <= num; j++){
                count[j][0] = count[j - 1][0] + count[j - 2][0];
                count[j][1] = count[j - 1][1] + count[j - 2][1];
            }
            sb.append(count[num][0]).append(' ').append(count[num][1]).append('\n');
        }

        System.out.println(sb);
    }
}