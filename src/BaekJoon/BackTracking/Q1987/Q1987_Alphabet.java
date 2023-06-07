package BaekJoon.BackTracking.Q1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987_Alphabet {

    public static int R;
    public static int C;
    public static int answer = 1;    // 단 한개 입력 대응 1
    public static char[][] map;
    public static boolean[] visited = new boolean[26];
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i = 0; i < R; i++){
            String row = br.readLine();

            for(int j = 0; j < C; j++){
                map[i][j] = row.charAt(j);
            }
        }

        backTracking(0, 0, 0);
        System.out.println(answer);
    }

    public static void backTracking(int x, int y, int cnt){
        int alphabet = map[x][y] - 65;

        for(int i = 0; i < 4; i++){
            int nexX = x + move[i][0];
            int nexY = y + move[i][1];

            if(isValidCoord(nexX, nexY)){
                if(!visited[alphabet]){
                    visited[alphabet] = true;
                    backTracking(nexX, nexY, cnt + 1);
                    visited[alphabet] = false;
                } else {
                    answer = Math.max(answer, cnt);
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= R || y < 0 || y >= C){
            return false;
        }
        return true;
    }
}