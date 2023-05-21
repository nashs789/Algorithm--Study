package BaekJoon.SetAndMap.Q17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q17219_FindPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, String> pwMap = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int idx = 0; idx < N; idx++){
            st = new StringTokenizer(br.readLine());

            pwMap.put(st.nextToken(), st.nextToken());
        }

        for(int idx = 0; idx < M; idx++){
            sb.append(pwMap.get(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }
}