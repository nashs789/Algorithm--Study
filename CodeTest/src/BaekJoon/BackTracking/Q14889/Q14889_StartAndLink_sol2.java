package BaekJoon.BackTracking.Q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889_StartAndLink_sol2 {

    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[][] board;
    public static int[] teamA;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        teamA = new int[N / 2];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
        System.out.println(min);
    }

    public static void backTracking(int idx, int cnt){
        if(cnt == N / 2){
            int[] teamB = getTeamB();

            min = Math.min(min, Math.abs(getTeamScore(teamA) - getTeamScore(teamB)));
            return;
        }

        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                teamA[cnt] = i;
                backTracking(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static int[] getTeamB(){
        int[] teamB = new int[N / 2];
        int arrIdx = 0;

        for(int idx = 0; idx < N; idx++){
            if(!visited[idx]){
                teamB[arrIdx++] = idx;
            }
        }

        return teamB;
    }

    public static int getTeamScore(int[] team){
        int sum = 0;

        for(int i = 0; i < team.length - 1; i++){
            for(int j = i + 1; j < team.length; j++){
                sum += board[team[i]][team[j]] + board[team[j]][team[i]];
            }
        }

        return sum;
    }
}
