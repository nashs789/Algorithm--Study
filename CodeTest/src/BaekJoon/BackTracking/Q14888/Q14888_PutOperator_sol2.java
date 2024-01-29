package BaekJoon.BackTracking.Q14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q14888_PutOperator_sol2 {

    public static int N;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] seq;
    public static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        backTracking(1, seq[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void backTracking(int idx, int sum){
        if(idx == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operators[i] != 0){
                continue;
            }
            operators[i]--;
            backTracking(idx + 1, calc(sum, seq[idx], i));
            operators[i]++;
        }
    }

    public static int calc(int sum, int operand, int operator){
        switch (operator){
            case  0:    // +
                return sum + operand;
            case  1:    // -
                return sum - operand;
            case  2:    // *
                return sum * operand;
            case  3:    // /
                return sum / operand;
            default:    // 실행 x
                return 0;
        }
    }
}
