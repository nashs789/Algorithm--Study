/**
 *  [ 효율성 ]
 *  - 메모리: 20176KB
 *  - 시간 : 404ms
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929_PrimeNumber {

    public static int srt;
    public static int end;
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        srt = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        prime = new boolean[end + 1];

        for(int idx = srt; idx <= end; idx++){
            if(prime[idx]){
                continue;
            }

            isPrimeNumber(idx);
        }

        for(int idx = 0; idx < prime.length; idx++){
            if(prime[idx]){
                sb.append(idx).append('\n');
            }
        }

        System.out.println(sb);
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

        prime[num] = true;
        return true;
    }
}
