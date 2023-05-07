package BaekJoon.Sorting.Q2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q2587_RepresentNumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for(int idx = 0; idx < 5; idx++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());
        int sum = list.stream().mapToInt(e -> e).sum();
        sb.append(sum / 5).append('\n').append(list.get(2));

        System.out.println(sb);
    }
}
