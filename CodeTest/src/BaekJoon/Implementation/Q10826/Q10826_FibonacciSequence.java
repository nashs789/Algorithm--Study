package BaekJoon.Implementation.Q10826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q10826_FibonacciSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num == 0){
            System.out.println(0);
        } else if(num == 1 || num == 2){
            System.out.println(1);
        } else {
            BigInteger n1 = new BigInteger("1");     // seq = 3
            BigInteger n2 = new BigInteger("2");     // seq = 4 (다음 값)
            BigInteger temp = new BigInteger("0");
            int seq = 3;

            while(num != seq){
                temp = n1;
                n1 = n2;
                n2 = temp.add(n2);

                seq++;
            }

            System.out.println(n2);
        }
    }
}