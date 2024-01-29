/**
 *  [ 효율성 ]
 *  - 메모리: 69284KB
 *  - 시간 : 696ms
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q2485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Q2485_StreetTrees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] trees = new int[testCase];       // 가로수 위치
        int[] dist = new int[testCase - 1];    // 가로수 사이의 거리의 차

        int firstNum = Integer.parseInt(br.readLine());
        trees[0] = firstNum;
        int min = firstNum;
        int max = firstNum;

        for(int idx = 0; idx < testCase - 1; idx++){
            int nextNum = Integer.parseInt(br.readLine());
            int num = nextNum - firstNum;
            trees[idx + 1] = nextNum;

            if(nextNum > max){
                max = nextNum;
            }

            if(nextNum < min){
                min = nextNum;
            }

            dist[idx] = num;
            firstNum = nextNum;
        }

        int gcd = 0;
        BigInteger num1 = new BigInteger(String.valueOf(dist[0]));

        for(int idx = 1; idx < dist.length; idx++){
            BigInteger num2 = new BigInteger(String.valueOf(dist[idx]));

            if(gcd == 0){
                gcd = num1.gcd(num2).intValue();
            } else {
                gcd = num2.gcd(new BigInteger(String.valueOf(gcd))).intValue();
            }
        }

        int cnt = 0;
        int idx = 1;

        for(int num = trees[0]; num < trees[trees.length - 1]; num += gcd){
            while(num + gcd < trees[idx]){
                num += gcd;
                cnt++;
            }
            idx++;
        }

        System.out.println(cnt);
    }
}