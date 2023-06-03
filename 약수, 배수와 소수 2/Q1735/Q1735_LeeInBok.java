/**
 *  [ 효율성 ]
 *  - 메모리: 16036KB
 *  - 시간 : 148ms
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1735_SumOfFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int child1 = Integer.parseInt(st.nextToken());
        int parent1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int child2 = Integer.parseInt(st.nextToken());
        int parent2 = Integer.parseInt(st.nextToken());

        int parent = lcm(parent1, parent2);
        int child = child1 * (parent / parent1) + child2 * (parent / parent2);

        while(true){
            int a = gcd(child, parent);

            if(a == 1){
                break;
            }

            child /= a;
            parent /= a;
        }

        System.out.println(child + " " + parent);
    }

    public static int lcm(int p1, int p2){
        return p1 * p2 / gcd(p1, p2);
    }

    public static int gcd(int p1, int p2){
        if(p2 == 0){
            return p1;
        } else {
            return gcd(p2, p1 % p2);
        }
    }
}