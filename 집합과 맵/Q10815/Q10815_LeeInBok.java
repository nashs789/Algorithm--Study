/**
 *  [ 효율성 ]
 *  - 메모리: 136476KB
 *  - 시간 : 984ms
 */
package BaekJoon.SetAndMap.Q10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q10815_NumberCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Set<Integer> has = new HashSet<>();

        for(int idx = 0; idx < N; idx++){
            has.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx < M; idx++){
            int isHas = Integer.parseInt(st.nextToken());

            if(has.contains(isHas)){
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }
}
