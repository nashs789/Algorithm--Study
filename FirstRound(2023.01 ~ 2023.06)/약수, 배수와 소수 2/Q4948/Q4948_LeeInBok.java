/**
 *  [ 효율성 ]
 *  - 메모리: 14592KB
 *  - 시간 : 364ms
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4948_GongJoon2 {

    public static boolean[] prime = new boolean[246913];

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
        if(prime[num]){
            return true;
        }

        if(num == 0 || num == 1){
            return false;
        }

        int sqrt = (int)Math.sqrt(num) + 1;

        for(int idx = 2; idx < sqrt; idx++){
            if(num % idx == 0){
                return false;
            }
        }

        prime[num] = true;
        return true;
    }
}
