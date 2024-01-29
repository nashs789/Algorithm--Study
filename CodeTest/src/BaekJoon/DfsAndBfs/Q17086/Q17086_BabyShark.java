package BaekJoon.DfsAndBfs.Q17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17086_BabyShark {

    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][] move = {
            {-1, -1}, {-1, 0}, {-1, 1},    // 좌상, 상, 우상
            {0, -1} ,          {0, 1} ,    // 좌  ,     우
            {1, -1} , {1, 0} , {1, 1}      // 좌하, 하, 우하
    };
    public static int maxDist = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 브루트포스 모든 좌표 정보
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){    // 상어로부터 안전거리는 필요하지 않음
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(maxDist);
    }

    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            for(int moveIdx = 0; moveIdx < 8; moveIdx++){
                int newX = curNode.x + move[moveIdx][0];
                int newY = curNode.y + move[moveIdx][1];

                if(isValidCoord(newX, newY) && !visited[newX][newY]){
                    // 좌표가 상어인 경우 안전거리 계산 후 bfs 종료
                    if(map[newX][newY] != 0){
                        maxDist = Math.max(maxDist, curNode.dist + 1);

                        return;
                    }

                    visited[newX][newY] = true;
                    queue.add(new Node(newX, newY, curNode.dist + 1));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M){
            return false;
        }

        return true;
    }

}

class Node{
    int x;
    int y;
    int dist;

    Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
