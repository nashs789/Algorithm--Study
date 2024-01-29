package BaekJoon.BackTracking.Q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q14889_StartAndLink2 {

    public static int[][] score;
    public static int cnt;
    public static int[] comb;
    public static boolean[] visited;
    public static boolean[] visited2;
    public static int answer = 100;
    public static Set<String> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        score = new int[cnt][cnt];
        comb = new int[cnt / 2];
        visited = new boolean[cnt + 1];
        visited2 = new boolean[cnt / 2];

        for(int i = 0; i < cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < cnt; j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);
        System.out.println(answer);
    }

    static void backTracking(int comIdx){
        for(int idx = 1; idx <= cnt; idx++){
            if(comIdx == (cnt / 2)){
                sb.setLength(0);

                for(int n : comb){
                    sb.append(n);
                }

                String str = sb.toString();

                if(!set.contains(str)){
                    int gap = Math.abs(scoreOfTeam(comb) - scoreOfTeam(getRestOfTeam()));

                    if(gap < answer){
                        answer = gap;
                    }

                    initDistinctNum(0, new StringBuilder());
                }

                return;
            }

            if(!visited[idx]){
                visited[idx] = true;
                comb[comIdx++] = idx;
                backTracking(comIdx--);
                visited[idx] = false;
            }
        }
    }

    static void initDistinctNum(int comIdx, StringBuilder sb2){
        for(int idx = 0; idx < comb.length; idx++){
            if(comIdx == cnt / 2){
                set.add(sb.toString());
                set.add(sb.reverse().toString());
                return;
            }

            if(!visited2[idx]){
                visited2[idx] = true;
                initDistinctNum(++comIdx, sb2.append(comb[idx]));
                visited2[idx] = false;
                comIdx--;
            }
        }
    }

    static int[] getRestOfTeam(){
        int[] arr = new int[cnt / 2];
        int arrIdx = 0;

        for(int idx = 1; idx < visited.length; idx++){
            if(!visited[idx]){
                arr[arrIdx++] = idx;
            }
        }

        return arr;
    }

    static int scoreOfTeam(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                sum += score[arr[i] - 1][arr[j] - 1] + score[arr[j] - 1][arr[i] - 1];
            }
        }

        return sum;
    }
}