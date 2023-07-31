/**
 * day 1: a
 * day 2: b
 * day 3: a + b
 * day 4: a + 2b
 * day 5: 2a + 3b
 * day 6: 3a + 5b
 * day 7: 5a + 8b
 *
 * arrA[i]: i+1 번째 날짜의 a 계수
 * arrB[i]: i+1 번째 날짜의 b 계수
 */

package BaekJoon.DynamicProgramming.Q2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2502_TigerEatingRiceCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arrA = new int[D];
        int[] arrB = new int[D];
        arrA[0] = arrB[1] = 1;
        arrA[1] = arrB[0] = 0;

        for(int i = 2; i < D; i++){
            arrA[i] = arrA[i - 2] + arrA[i - 1];
            arrB[i] = arrB[i - 2] + arrB[i - 1];
        }

        for(int i = 1;;i++){
            // ex) 3a + 5b = 41 ===> 5b = 41 - (3 * 2(i 값))
            int res = K - arrA[D - 1] * i;

            // ex) 5b = 35 ===> b = 35 % 5
            if(res % arrB[D - 1] == 0){
                System.out.println(i);
                System.out.println(res / arrB[D - 1]);
                System.exit(0);
            }
        }
    }
}