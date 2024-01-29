package BaekJoon.BackTracking.Q14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q14888_PutOperator {

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] oper;   // 0: +    1: -    2: *    3: /

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        oper = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        backTracking(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void backTracking(int idx, int sum){
        if(idx == arr.length - 1){
            if(sum > max){
                max = sum;
            }

            if(sum < min){
                min = sum;
            }
        }

        while(idx != arr.length - 1){
            for(int j = 0; j < oper.length; j++){
                if(oper[j] != 0){
                    int newSum = calc(j, sum, arr[idx + 1]);

                    oper[j] -= 1;
                    backTracking(++idx, newSum);
                    idx--;
                    oper[j] += 1;
                }
            }
            return;
        }
    }

    public static int calc(int oper, int op1, int op2){
        switch (oper){
            case 0:
                return op1 + op2;
            case 1:
                return op1 - op2;
            case 2:
                return op1 * op2;
            case 3:
                // op1이 0인 케이스 처리가 필요한가?
                if(op1 < 0){
                    return (Math.abs(op1) / op2) * -1;
                }

                return op1 / op2;
            default:    // 들어올 일 없음
                return 0;
        }
    }
}