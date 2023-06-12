package BaekJoon.Implementation.Q2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2748_FibonacciSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num == 1 || num == 2){
            System.out.println(1);
        } else {
            long n1 = 1;     // seq = 3
            long n2 = 2;     // seq = 4 (다음 값)
            int seq = 3;

            while(num != seq){
                long temp = 0;

                temp = n1;
                n1 = n2;
                n2 = temp + n2;

                seq++;
            }

            System.out.println(n2);
        }
    }
}