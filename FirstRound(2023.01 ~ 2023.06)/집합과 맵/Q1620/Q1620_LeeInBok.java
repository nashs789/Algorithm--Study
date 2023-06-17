/**
 *  [ 효율성 ]
 *  - 메모리: 58180KB
 *  - 시간 : 532ms
 */

package BaekJoon.SetAndMap.Q1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620_PokemonMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int total = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();
        int num = 1;

        for(int idx = 0; idx < total; idx++){
            String name = br.readLine();

            nameMap.put(name, num);
            numMap.put(num++, name);
        }

        for(int idx = 0; idx < cnt; idx++){
            String str = br.readLine();
            int temp = str.charAt(0);

            if(49 <= temp && temp <= 57){
                int strNum = Integer.parseInt(str);

                sb.append(numMap.get(strNum)).append('\n');
            } else {
                sb.append(nameMap.get(str)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
