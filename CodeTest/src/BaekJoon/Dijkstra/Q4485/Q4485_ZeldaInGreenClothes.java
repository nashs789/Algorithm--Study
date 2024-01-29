package BaekJoon.Dijkstra.Q4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q4485_ZeldaInGreenClothes {

    public static int N;
    public static int[][] cave;
    public static int[][] rupee;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int solNum = 1;

        while(true){
            N = Integer.parseInt(br.readLine());
            cave = new int[N][N];
            rupee = new int[N][N];

            if(N == 0){
                break;
            }

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                Arrays.fill(rupee[i], Integer.MAX_VALUE);

                for(int j = 0; j < N; j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            sb.append("Problem ").append(solNum++).append(": ").append(rupee[N - 1][N - 1]).append('\n');
        }
        System.out.println(sb);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.rupee - b.rupee);

        pQueue.add(new Node(0, 0, cave[0][0]));
        rupee[0][0] = cave[0][0];

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(rupee[curNode.x][curNode.y] < curNode.rupee){
                continue;
            }

            for(int idx = 0; idx < 4; idx++){
                int newX = curNode.x + move[idx][0];
                int newY = curNode.y + move[idx][1];

                if(!isValidCoord(newX, newY)){
                    continue;
                }

                int newRupee = cave[newX][newY] + curNode.rupee;

                if(rupee[newX][newY] > newRupee){
                    rupee[newX][newY] = newRupee;
                    pQueue.add(new Node(newX, newY, newRupee));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }

        return true;
    }
}

class Node {
    int x;
    int y;
    int rupee;

    public Node(int x, int y, int rupee) {
        this.x = x;
        this.y = y;
        this.rupee = rupee;
    }
}

// 9:01