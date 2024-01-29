/**
 *  [ 효율성 ]
 *  - 메모리: 16460KB
 *  - 시간 : 160ms
 */

package BaekJoon.DfsAndBfs.Q2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q2667_ComplexNumber_sol2 {

    public static int N;
    public static int[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static boolean[][] visited;
    public static PriorityQueue<Integer> pQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int idx = 0; idx < N; idx++){
            map[idx] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(new Vertex(i, j));
                    cnt++;
                }
            }
        }

        sb.append(cnt + "\n");

        while(!pQueue.isEmpty()){
            sb.append(pQueue.poll() + "\n");
        }

        System.out.print(sb);
    }

    public static void bfs(Vertex srtV){
        Queue<Vertex> queue = new LinkedList<>();

        int cnt = 0;
        queue.add(srtV);
        visited[srtV.x][srtV.y] = true;

        while(!queue.isEmpty()){
            Vertex curV = queue.poll();
            cnt++;

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int nextX = curV.x + move[moveIdx][0];
                int nextY = curV.y + move[moveIdx][1];

                if(isValidCoord(nextX, nextY) && map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Vertex(nextX, nextY));
                }
            }
        }

        pQueue.add(cnt);
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

class Vertex {
    int x;
    int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}