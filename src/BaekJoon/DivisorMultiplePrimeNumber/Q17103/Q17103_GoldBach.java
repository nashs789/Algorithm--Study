package BaekJoon.DivisorMultiplePrimeNumber.Q17103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q17103_GoldBach {

    public static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        isPrimeNumber();

        for(int i = 0; i < testCase; i++){
            Set<Integer> pair = new HashSet<>();
            int num = Integer.parseInt(br.readLine());
            int gap = 0;
            int cnt = 0;

            for(int j = 2; j < num; j++){
                if(prime[j]){
                    continue;
                }

                gap = num - j;

                if(!prime[gap] && !pair.contains(gap)){
                    pair.add(num);
                    pair.add(j);
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    private static void isPrimeNumber() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i < prime.length; i++){
            if(prime[i]){
                continue;
            }

            int sqrt = (int) Math.sqrt(i) + 1;

            for(int j = 2; j < sqrt; j++){
                if(i % j == 0){
                    return;
                }
            }

            // 소수인 경우
            for(int idx = i + i; idx < 1000001; idx+=i){
                prime[idx] = true;
            }
        }
    }
}
