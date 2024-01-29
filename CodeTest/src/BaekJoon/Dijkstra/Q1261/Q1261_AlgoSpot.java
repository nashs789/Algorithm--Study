package BaekJoon.Dijkstra.Q1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1261_AlgoSpot {

    public static int N;
    public static int M;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int[][] maze;
    public static int[][] broke;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[M][N];
        broke = new int[M][N];

        final int MAX = N * M;

        for(int idx = 0; idx < broke.length; idx++){
            Arrays.fill(broke[idx], MAX);
        }

        for(int i = 0; i < M; i++){
            int arr[] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < N; j++){
                maze[i][j] = arr[j];
            }
        }

        dijkstra();

        System.out.println(broke[M - 1][N - 1]);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.broke - b.broke);

        pQueue.add(new Node(0, 0, 0));
        broke[0][0] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(broke[curNode.x][curNode.y] < curNode.broke){
                continue;
            }

            for(int idx = 0; idx < 4; idx++){
                int newX = curNode.x + move[idx][0];
                int newY = curNode.y + move[idx][1];

                if(!isValidCoord(newX, newY)){
                    continue;
                }

                int wall = maze[newX][newY];
                int newBroke = curNode.broke + wall;

                if(broke[newX][newY] > newBroke){
                    broke[newX][newY] = newBroke;
                    pQueue.add(new Node(newX, newY, newBroke));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= M || y < 0 || y >= N){
            return false;
        }

        return true;
    }
}

class Node{
    int x;
    int y;
    int broke;

    public Node(int x, int y, int broke) {
        this.x = x;
        this.y = y;
        this.broke = broke;
    }
}