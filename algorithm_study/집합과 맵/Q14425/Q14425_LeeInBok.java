/**
 *  [ 효율성 ]
 *  - 메모리: 31072KB
 *  - 시간 : 412ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q14425_LeeInBok {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int answer = 0;

        for(int idx = 0; idx < N; idx++){
            set.add(br.readLine());
        }

        for(int idx = 0; idx < M; idx++){
            if(set.contains(br.readLine())){
                answer++;
            }
        }

        System.out.println(answer);
    }
}