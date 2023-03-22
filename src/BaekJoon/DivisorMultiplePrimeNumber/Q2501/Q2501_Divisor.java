package BaekJoon.DivisorMultiplePrimeNumber.Q2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2501_Divisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int sqrt = (int) Math.sqrt(p) + 1;

        for(int idx = 1; idx < sqrt; idx++){
            if(p % idx == 0){
                set.add(idx);
                set.add(p / idx);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());

        System.out.println(list.size() >= q ? list.get(q - 1) : 0);
    }
}