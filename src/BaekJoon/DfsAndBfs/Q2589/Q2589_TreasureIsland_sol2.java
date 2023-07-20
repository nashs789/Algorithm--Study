package BaekJoon.DfsAndBfs.Q2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2589_TreasureIsland_sol2 {

    public static int N;
    public static int M;
    public static int answer = Integer.MIN_VALUE;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().split("");
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j].equals("L")){
                    bfs(i, j);
                }
            }
        }

        System.out.print(answer);
    }

    public static void bfs(int x, int y){
        Queue<Vertex> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Vertex(x, y, 0));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Vertex curV = queue.poll();
            answer = Math.max(answer, curV.dist);

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int nextX = curV.x + move[moveIdx][0];
                int nextY = curV.y + move[moveIdx][1];

                if(isValidCoord(nextX, nextY) && map[nextX][nextY].equals("L") && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Vertex(nextX, nextY, curV.dist + 1));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}