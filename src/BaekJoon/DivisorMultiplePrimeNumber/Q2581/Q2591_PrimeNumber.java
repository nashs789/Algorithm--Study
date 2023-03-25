package BaekJoon.DivisorMultiplePrimeNumber.Q2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2591_PrimeNumber {

    private static int M = 0;
    private static int N = 0;
    private static int sum = 0;
    private static List<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        for(int idx = M; idx <= N; idx++){
            if(idx <= 1 || (idx % 2 == 0 && idx != 2)){
                continue;
            }

            list.add(idx);
        }

        list.sort(Comparator.naturalOrder());
        remove();

        list.forEach(e -> sum += e);

        if(sum == 0){
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(list.stream().min(Comparator.naturalOrder()).get());
        }

        System.out.println(sb.toString());
    }

    private static void remove(){
        int sqrtN = (int) Math.sqrt(N);
        List<Integer> removeList = new ArrayList<>();

        for(int i = 2; i <= sqrtN; i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) % i == 0 && list.get(j) != i){
                    removeList.add(j);
                }
            }

            for(int j = removeList.size() - 1; j >= 0; j--){
                list.remove((int)removeList.get(j));
            }

            removeList.clear();
        }
    }
}