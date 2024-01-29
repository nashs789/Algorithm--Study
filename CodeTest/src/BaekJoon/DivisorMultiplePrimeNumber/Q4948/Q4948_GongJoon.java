package BaekJoon.DivisorMultiplePrimeNumber.Q4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4948_GongJoon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num;

        while((num = Integer.parseInt(br.readLine())) != 0){
            int doubleNum = (num++) * 2;
            int cnt = 0;

            for(int idx = num; idx <= doubleNum; idx++){
                if(isPrimeNumber(idx)){
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    public static boolean isPrimeNumber(int num){
        if(num == 0 || num == 1){
            return false;
        }

        int sqrt = (int)Math.sqrt(num) + 1;

        for(int idx = 2; idx < sqrt; idx++){
            if(num % idx == 0){
                return false;
            }
        }

        return true;
    }
}
