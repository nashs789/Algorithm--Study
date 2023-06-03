package BaekJoon.DivisorMultiplePrimeNumber.Q4134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4134_NextPrimeNumber {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long testCase = Integer.parseInt(br.readLine());

        for(long idx = 0; idx < testCase; idx++){
            long num = Long.parseLong(br.readLine());

            while(!isPrimeNumber(num)){
                num++;
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static boolean isPrimeNumber(long num){
        if(num == 0 || num == 1){
            return false;
        }

        long sqrt = (long)Math.sqrt(num) + 1;

        for(long idx = 2; idx < sqrt; idx++){
            if(num % idx == 0){
                return false;
            }
        }

        sb.append(num).append('\n');
        return true;
    }
}
