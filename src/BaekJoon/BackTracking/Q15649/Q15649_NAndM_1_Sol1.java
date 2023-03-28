package BaekJoon.BackTracking.Q15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15649_NAndM_1_Sol1 {

    private static Set<String> set = new HashSet<>();
    private static int N = 0;
    private static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int idx = 1; idx <= N; idx++){
            getSequence(idx, Integer.toString(idx), new boolean[N + 1]);
        }

        List<String> list = new ArrayList<>(set);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) == o2.charAt(0)){
                    for(int idx = 2; idx < o1.length(); idx+=2){
                        if(o1.charAt(idx) != o2.charAt(idx)){
                            return o1.charAt(idx) - o2.charAt(idx);
                        }
                    }
                }

                return o1.charAt(0) - o2.charAt(0);
            }
        });

        for(String str : list){
            System.out.println(str);
        }
    }

    private static void getSequence(int index, String number, boolean[] visited) {
        visited[index] = true;
        
        if(number.length() == (M * 2) - 1){
            set.add(number);
            return;
        }
        
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                getSequence(i, number + " " + i, Arrays.copyOf(visited, visited.length));
            }
        }
    }
}