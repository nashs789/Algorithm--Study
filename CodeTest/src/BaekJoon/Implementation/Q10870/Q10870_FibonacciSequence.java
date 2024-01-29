package BaekJoon.Implementation.Q10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10870_FibonacciSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num == 0){
            System.out.println(0);
        } else if(num == 1 || num == 2){
            System.out.println(1);
        } else {
            int n1 = 1;     // seq = 3
            int n2 = 2;     // seq = 4 (다음 값)
            int seq = 3;

            while(num != seq){
                int temp = 0;

                temp = n1;
                n1 = n2;
                n2 = temp + n2;

                seq++;
            }

            System.out.println(n2);
        }
    }
}
