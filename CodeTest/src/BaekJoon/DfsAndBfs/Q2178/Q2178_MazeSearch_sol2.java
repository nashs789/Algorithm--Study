package BaekJoon.DfsAndBfs.Q2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_MazeSearch_sol2 {

    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < M; j++){
                map[i][j] = arr[j];
            }
        }

        bfs();
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            // 최종 도착지에 도착 했을 경우 출력 후 종료
            if(curNode.x == N - 1 && curNode.y == M - 1){
                System.out.println(curNode.dist);
                return;
            }

            // '상', '하', '좌', '우' 4방향 이동
            for(int idx = 0; idx < 4; idx++){
                int nextX = curNode.x + move[idx][0];
                int nextY = curNode.y + move[idx][1];

                // 유효한 좌표 값 && 방문하지 않음 && 이동할 수 있는 '1'
                if(isValidCoord(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, curNode.dist + 1));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class Node{
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}