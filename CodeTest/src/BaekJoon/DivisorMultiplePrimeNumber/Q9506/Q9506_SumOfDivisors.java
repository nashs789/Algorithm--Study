package BaekJoon.DivisorMultiplePrimeNumber.Q9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9506_SumOfDivisors {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());

            if(n == -1){
                break;
            }

            Set<Integer> set = new HashSet<>();
            set.add(1);    // 1은 항상 약수
            int sqrt = (int) Math.sqrt(n) + 1;
            int sum = 0;

            for(int idx = 2; idx < sqrt; idx++){
                if(n % idx == 0){
                    sum += idx;
                    sum += n / idx;
                    set.add(idx);
                    set.add(n / idx);
                }
            }

            // +1 1은 항상 약수
            if(n == sum + 1){
                List<Integer> list = new ArrayList<>(set);
                list.sort(Comparator.naturalOrder());

                sb.append(n).append(" = ");

                for(int num : list){
                    sb.append(num).append(" + ");
                }

                sb.delete(sb.length() - 3, sb.length());
                sb.append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.").append("\n");
            }
        }

        System.out.println(sb);
    }
}

// 00:12
