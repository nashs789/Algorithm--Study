package BaekJoon.BruteForce.Q2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231_DivideAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        // 생성자는 언제나 입력값보다 작을 것
        int min = num;

        for(int idx = 0; idx < num; idx++){
            int tempSum = idx;
            int tempNum = idx;
            int divisor = 1000000;

            while(divisor != 1){
                tempSum += tempNum / divisor;
                tempNum %= divisor;
                divisor /= 10;
            }

            tempSum += tempNum;

            if(tempSum == num){
                min = idx;
                break;
            }
        }

        if(min == num){
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}