package BaekJoon.Sorting.Q18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870_CompactCoordinate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        int[] orgArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] copyArr = Arrays.stream(Arrays.copyOf(orgArr, orgArr.length)).distinct().toArray();

        Arrays.sort(copyArr);
        
        // 숫자, 순위
        Map<Integer, Integer> map = new HashMap<>();

        for(int idx = 0; idx < copyArr.length; idx++){
            map.put(copyArr[idx], idx);
        }

        for(int idx = 0; idx < cnt; idx++){
            sb.append(map.get(orgArr[idx])).append(' ');
        }

        System.out.println(sb);
    }
}