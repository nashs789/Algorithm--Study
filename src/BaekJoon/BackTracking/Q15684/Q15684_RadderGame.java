package BaekJoon.BackTracking.Q15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684_RadderGame {

    public static int N;    // 세로선
    public static int M;    // 가로선
    public static int H;    // 세로선 사이의 사다리
    public static int[][] radder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        radder = new int[H][N];

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            radder[x][y] = 1;
            radder[x][y + 1] = 2;
        }

        for(int idx = 1; idx <= 3; idx++){
            backTracking(0,0, idx);
        }
        System.out.println(-1);
    }

    public static void backTracking(int x, int cnt, int r){
        if(cnt > r){
            return;
        }

        if(move()){
            System.out.println(cnt);
            System.exit(0);
        }

        for(int i = x; i < H; i++){
            for(int j = 0; j < N - 1; j++){
                if(radder[i][j] == 0 && radder[i][j + 1] == 0){
                    radder[i][j] = 1;
                    radder[i][j + 1] = 2;
                    backTracking(i,cnt + 1, r);
                    radder[i][j] = radder[i][j + 1] = 0;
                }
            }
        }
    }

    public static boolean move() {
        for (int i = 0; i < N; i++) {    // 모든 시작점에서 i -> i 인지 확인
            int x = 0;    // start point X
            int y = i;    // start point Y

            while (true) {
                if (x == H - 1) {
                    if (radder[x][y] != 0) {  // 가로 사다리가 있는 경우
                        y = radder[x][y] == 1 ? y + 1 : y - 1;
                    }

                    if (y != i) {   // i -> i
                        return false;
                    }
                    break;
                }

                if (radder[x][y] != 0) {  // 가로 사다리가 있는 경우
                    y = radder[x][y] == 1 ? y + 1 : y - 1;
                }

                x += 1;
            }
        }

        return true;
    }
}