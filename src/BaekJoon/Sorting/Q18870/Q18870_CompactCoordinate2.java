package BaekJoon.Sorting.Q18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870_CompactCoordinate2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        Integer[] orgArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        SortedSet<Integer> set = new TreeSet<>();

        set.addAll(Arrays.asList(orgArr));

        // 숫자, 순위
        Map<Integer, Integer> map = new HashMap<>();

        int rank = 0;

        while (!set.isEmpty()){
            map.put(set.first(), rank++);
            set.remove(set.first());
        }

        for(int idx = 0; idx < cnt; idx++){
            sb.append(map.get(orgArr[idx])).append(' ');
        }

        System.out.println(sb);
    }
}