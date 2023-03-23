package BaekJoon.DivisorMultiplePrimeNumber.Q11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q11653_Factorization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());

        while(num != 1){
            int sqrt = (int) Math.sqrt(num) + 1;
            int orgNum = num;

            for(int idx = 2; idx < sqrt; idx++){
                if(num % idx == 0){
                    list.add(idx);
                    num /= idx;
                    break;
                }
            }

            // 더 이상 나누어지지 않는 수가 되었을 때(= if문 로직 타지 않았을 경우)
            if(num == orgNum){
                list.add(num);
                break;
            }
        }

        list.sort(Comparator.naturalOrder());
        for(int n : list){
            System.out.println(n);
        }
    }
}
