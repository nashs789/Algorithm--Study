/**
 *  [ 효율성 ]
 *  - 메모리: 16396KB
 *  - 시간 : 156ms
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q9613_SumOfGcd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCnt = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < testCnt; idx++){
            String[] arr = br.readLine().split(" ");

            long sum = 0;

            for(int i = 1; i < arr.length - 1; i++){
                for(int j = i + 1; j < arr.length; j++){
                    BigInteger a = new BigInteger(arr[i]);
                    sum += a.gcd(new BigInteger(arr[j])).intValue();
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}