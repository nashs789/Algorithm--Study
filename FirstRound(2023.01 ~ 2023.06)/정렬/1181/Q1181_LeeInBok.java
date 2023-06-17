/**
 *  [ 효율성 ]
 *  - 메모리: 27376KB
 *  - 시간 : 376ms
 */
package BaekJoon.String.Q1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181_WordSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String[] answer;

        for(int idx = 0; idx < cnt; idx++){
            set.add(br.readLine());
        }

        answer = Arrays.stream(set.toArray()).toArray(String[]::new);

        Arrays.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    for(int idx = 0; idx < o1.length(); idx++){
                        if(o1.charAt(idx) != o2.charAt(idx)){
                            return o1.charAt(idx) - o2.charAt(idx);
                        }
                    }
                }

                return o1.length() - o2.length();
            }
        });
        
        for(String str : answer){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
