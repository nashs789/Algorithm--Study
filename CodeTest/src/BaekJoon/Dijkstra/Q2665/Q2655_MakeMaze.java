package BaekJoon.Dijkstra.Q2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2655_MakeMaze {

    public static final int MAX = 300;

    public static int n;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int[][] maze;
    public static int[][] broke;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        broke = new int[n][n];

        for(int idx = 0; idx < broke.length; idx++){
            Arrays.fill(broke[idx], MAX);
        }

        for(int i = 0; i < n; i++){
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < n; j++){
                maze[i][j] = arr[j];
            }
        }

        dijkstra();

        System.out.println(broke[n - 1][n - 1]);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.broke - b.broke);

        pQueue.add(new Node(0, 0, 0));
        broke[0][0] = 0;

        while (!pQueue.isEmpty()){
            Node curNode = pQueue.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            // 현재 노드가 부셔온 벽이 기존에 부신 벽의 최소 값보다 큰 경우
            if(broke[curX][curY] < curNode.broke){
                continue;
            }

            for(int idx = 0; idx < 4; idx++){
                int newX = curX + move[idx][0];
                int newY = curY + move[idx][1];

                // 유효하지 않은 좌표인 경우
                if(!isValidCoord(newX, newY)){
                    continue;
                }

                int wall = maze[newX][newY] == 1 ? 0 : 1;    // 벽이면 broke 추가 x
                int newBroke = curNode.broke + wall;

                if(broke[newX][newY] > newBroke){
                    broke[newX][newY] = newBroke;
                    pQueue.add(new Node(newX, newY, newBroke));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n){
            return false;
        }

        return true;
    }
}

class Node {
    int x;
    int y;
    int broke;

    public Node(int x, int y, int broke) {
        this.x = x;
        this.y = y;
        this.broke = broke;
    }
}