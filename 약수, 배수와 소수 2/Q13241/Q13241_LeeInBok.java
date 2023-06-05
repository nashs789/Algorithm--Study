/**
 *  [ 효율성 ]
 *  - 메모리: 14328KB
 *  - 시간 : 124ms
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q13241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q13241_GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        long num1 = Integer.parseInt(arr[0]);
        long num2 = Integer.parseInt(arr[1]);
        BigInteger bigNum = new BigInteger(arr[0]);
        int gcd = bigNum.gcd(new BigInteger(arr[1])).intValue();

        System.out.println(num1 * num2 / gcd);
    }
}
