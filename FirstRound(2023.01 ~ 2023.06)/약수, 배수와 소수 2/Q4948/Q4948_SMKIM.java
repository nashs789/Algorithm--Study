package 백준.약수_배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 메모리:26040KB
* 시간 :192ms
* */
public class 베르트랑_공준_4948 {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int count = 0;
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            make_prime(num);


            for (int i = num + 1; i <= num* 2; i++) {
                if (prime[i] == false) {    
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    public static void make_prime(int num) {

        prime = new boolean[num*2 + 1];	// 0 ~ N
      
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {

            if (prime[i] == true) {
                continue;
            }

            for (int j = i * i; j < prime.length; j +=  i) {
                prime[j] = true;
            }
        }

    }


}
