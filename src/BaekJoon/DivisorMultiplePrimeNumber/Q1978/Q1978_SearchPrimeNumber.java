package BaekJoon.DivisorMultiplePrimeNumber.Q1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1978_SearchPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int idx = 0; idx < nums.length; idx++){
            if(isPrimeNumber(nums[idx])){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isPrimeNumber(int num) {
        if(num == 1){
            return false;
        }

        int sqrt = (int) Math.sqrt(num) + 1;

        for(int idx = 2; idx < sqrt; idx++){
            if(num % idx == 0){
                return false;
            }
        }

        return true;
    }
}
