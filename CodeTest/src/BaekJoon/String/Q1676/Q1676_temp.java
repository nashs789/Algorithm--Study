/**
* Author    : Lee In Bok 
* Date      : 2023.11.15(Wen)
* Spend Time: 11m 29s
* Runtime   : 132 ms
* Memory    : 14576 KB
* Algoritm  : BigInteger
 */

package BaekJoon.String.Q1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1676_temp {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger temp = new BigInteger("1");
        int cnt = 0;

        for(long i = 1; i <= N; i++){
            temp = temp.multiply(BigInteger.valueOf(i));
        }

        String resultStr = temp.toString();

        for(int i = resultStr.length() - 1; i >= 0; i--){
            if(resultStr.charAt(i) == '0'){
                cnt += 1;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
