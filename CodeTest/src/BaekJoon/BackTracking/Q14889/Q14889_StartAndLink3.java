package BaekJoon.BackTracking.Q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889_StartAndLink3 {

    public static int[][] score;
    public static int cnt;
    public static int[] comb;
    public static boolean[] visited;
    public static int answer = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        score = new int[cnt][cnt];
        comb = new int[cnt / 2];
        visited = new boolean[cnt + 1];

        for(int i = 0; i < cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < cnt; j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(1, 0);
        System.out.println(answer);
    }

    static void backTracking(int forIdx, int comIdx){
        if(comIdx == (cnt / 2)){
            int gap = Math.abs(scoreOfTeam(comb) - scoreOfTeam(getRestOfTeam()));

            if(gap == 0){
                System.out.println(gap);
                System.exit(0);
            }

            if(gap < answer){
                answer = gap;
            }
            return;
        }

        for(int idx = forIdx; idx <= cnt; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                comb[comIdx++] = idx;
                backTracking(++forIdx, comIdx--);
                visited[idx] = false;
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