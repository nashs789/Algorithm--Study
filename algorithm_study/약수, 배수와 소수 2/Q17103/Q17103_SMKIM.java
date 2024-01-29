package 백준.약수_배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 메모리 :16156
* 시간 : 252
* */
public class 골드바흐파티션_17103 {

    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        make_prime();

        for (int i = 0; i < num; i++) {
            int number = Integer.parseInt(br.readLine());
            int result = 0;

            for (int j = 2; j <= number /2; j++) {
                if (!prime[j] && !prime[number - j]){
                    result++;
                }

            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    public static void make_prime() {

        prime = new boolean[1000000 +1];	// 0 ~ N

        prime[0] = prime[1] = true;

        // 제곱근 함수 : Math.sqrt()
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
