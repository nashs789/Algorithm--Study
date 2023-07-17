package BaekJoon.DfsAndBfs.Q1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1743_FoodWaste {

    public static int N;
    public static int M;
    public static int K;
    public static int max = Integer.MIN_VALUE;
    public static int[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int idx = 0; idx < K; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.print(max);
    }

    public static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        int size = 0;

        visited[x][y] = true;
        queue.add(new Node(x, y));

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            size++;

            // 상, 하, 좌, 우 이동
            for(int idx = 0; idx < 4; idx++){
                int newX = curNode.x + move[idx][0];
                int newY = curNode.y + move[idx][1];

                if(isValidCoord(newX, newY) && map[newX][newY] == 1 && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    queue.add(new Node(newX, newY));
                }
            }
        }

        return size;
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}