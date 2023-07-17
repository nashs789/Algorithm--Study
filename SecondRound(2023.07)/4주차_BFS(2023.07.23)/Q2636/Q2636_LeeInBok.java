/**
 *  [ 효율성 ]
 *  - 메모리: 15796KB
 *  - 시간 : 160ms
 */

package BaekJoon.DfsAndBfs.Q2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2636_Cheese {

    public static int N;
    public static int M;
    public static int cheeseCnt = 0;
    public static int[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                int info = Integer.parseInt(st.nextToken());

                if(info == 1){
                    cheeseCnt++;
                }

                map[i][j] = info;
            }
        }

        int time = 0;

        while(true){
            int prevCnt = cheeseCnt;

            time++;
            bfs();

            // 치즈가 안남아 있는 경우 현재까지 걸린 시간 + 이전 시간에 남아있던 치즈 수량 출력
            if(cheeseCnt == 0){
                System.out.println(time);
                System.out.println(prevCnt);
                break;
            }
        }
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            for(int idx = 0; idx < 4; idx++){
                int nextX = curNode.x + move[idx][0];
                int nextY = curNode.y + move[idx][1];

                if(isValidCoord(nextX, nextY) && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;

                    // 치즈 녹이기 + 총 치즈 숫자에서 -1
                    if(map[nextX][nextY] == 1){
                        map[nextX][nextY] = 0;
                        cheeseCnt--;
                    } else {
                        queue.add(new Node(nextX, nextY));
                    }
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

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}