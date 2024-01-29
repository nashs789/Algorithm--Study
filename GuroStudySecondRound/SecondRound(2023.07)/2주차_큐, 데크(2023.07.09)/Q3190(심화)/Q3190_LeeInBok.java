/**
 *  [ 효율성 ]
 *  - 메모리: 14764KB
 *  - 시간 : 140ms
 */

package BaekJoon.QueueAndDeque.Q3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3190_Snake {

    public static int N;
    public static int[][] board;
    public static int move[][] ={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static Map<Integer, String> regMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    // N * N 사이즈 보드
        int K = Integer.parseInt(br.readLine());    // 사과의 개수
        board = new int[N][N];

        for(int idx = 0; idx < K; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());    // 뱀의 방향 전환 정보

        for(int idx = 0; idx < L; idx++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String reg = st.nextToken();

            regMap.put(time, reg);
        }

        run();
    }

    public static void run(){
        Queue<Node> queue = new LinkedList<>();
        Node snake = new Node(0, 0);
        queue.add(snake);
        int time = 0;
        int direction = 1;    // 0: 상, 1: 우, 2: 하, 3: 좌

        while(true){
            int newX = snake.x + move[direction][0];
            int newY = snake.y + move[direction][1];
            time++;

            // 벽에 부딪히는 경우
            if(!isValidCoord(newX, newY)){
                break;
            }

            // 뱀 머리 변경
            snake = new Node(newX, newY);

            // 자기 몸에 부딪히는 경우
            if(queue.contains(snake)){
                break;
            }

            // 사과를 마주 했을 경우
            if(board[newX][newY] == 1){
                queue.add(snake);
                board[newX][newY] = 0;
            } else {
                queue.poll();
                queue.add(snake);
            }

            // 방향을 바꿀 시간이 된 경우 방향 전환
            if(regMap.containsKey(time)){
                String reg = regMap.get(time);

                if(reg.equals("D")){
                    direction = direction == 3 ? 0 : direction + 1;
                } else {
                    direction = direction == 0 ? 3 : direction - 1;
                }
            }
        }

        System.out.println(time);
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }
        return true;
    }
}

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        Node node = (Node) obj;

        return this.x == node.x && this.y == node.y;
    }
}
