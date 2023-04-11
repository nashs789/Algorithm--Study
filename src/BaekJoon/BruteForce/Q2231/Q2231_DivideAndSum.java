package BaekJoon.BruteForce.Q2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231_DivideAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int min = num; // 생성자는 언제나 입력값보다 작을 것

        for(int idx = 0; idx < num; idx++){
            int tempSum = idx;
            int tempNum = idx;
            int divisor = 1000000;  // 입력받을 수 있는 자연수의 최대 값

            // divisor: 1000000, 100000, 10000.... 10, 1
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

        if(min == num){ // min 값이 한 번도 변하지 않은 경우 생성자가 존재하지 않는다
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}