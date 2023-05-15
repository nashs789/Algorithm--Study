/**
 *  [ 효율성 ]
 *  - 메모리: 185736KB
 *  - 시간 : 1396ms
 */
package BaekJoon.SetAndMap.Q10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816_NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cardMap = new HashMap<>();

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());

            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        int temp = Integer.parseInt(br.readLine()); // 필요 없는 변수
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int n : nums){
            sb.append(cardMap.getOrDefault(n, 0)).append(' ');
        }

        System.out.println(sb);
    }
}