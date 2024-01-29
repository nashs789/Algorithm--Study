package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  [ 효율성 ]
 *  - 메모리:  15688 KB
 *  - 시간 : 164	 ms
 */

//https://www.acmicpc.net/problem/2178
public class Q2178 { // 미로 탐색

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy={1, 0, -1, 0};
    private static int[][] board;
    private static boolean[][] visited;
    private static int N,M;
    private static void bfs(int x, int y){


        Queue<int[]> queue = new LinkedList<>();

        // {0,0} 삽입
        queue.offer(new int[]{x,y});

        visited[x][y] = true;

        while (!queue.isEmpty()){

            int[] now = queue.poll();

            for (int k=0; k < 4; k++){

                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx >=0 && ny >= 0 && nx < N && ny < M ){ // 유효한 좌표

                    if (board[nx][ny] != 0 && !visited[nx][ny]){ // 갈 수 있는 칸 && 방문 검사
                        visited[nx][ny] = true;

                        board[nx][ny] = board[now[0]][now[1]] + 1; // A 배열에 depth 를 현재 노드의 depth + 1 로 수정

                        //System.out.println("now[0] >>> " + now[0]  +  " now[1] >>> " + now[1]+ k + " >>> " + Arrays.deepToString(board));

                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        String line;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            line = st.nextToken();
            for(int j=0; j<M; j++){
                board[i][j]= Integer.parseInt(line.substring(j,j+1));
            }
        }

        //System.out.println(Arrays.deepToString(board));

        bfs(0, 0);

        System.out.println(board[N - 1][M - 1]);

    }
}
