package BaekJoon.DfsAndBfs.Q16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16928_SnakeAndLadder {

    public static int N;
    public static int M;
    public static boolean[] visited = new boolean[100];
    public static Map<Integer, Integer> moveInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = N + M;

        for(int idx = 0; idx < sum; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            moveInfo.put(x, y);
        }

        bfs();
    }

    static void bfs(){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(1, 0));
        visited[0] = true;

        while (!queue.isEmpty()){
            Point p = queue.poll();

            if(p.curPoint == 100){
                System.out.println(p.cnt);
                break;
            }

            // 주사위 1 ~ 6 까지
            for(int idx = 1; idx <= 6; idx++){
                int nextPoint = p.curPoint + idx;
                int nextCnt = p.cnt + 1;

                // 클래스 메모리 할당 줄이기 위한 조건
                if(nextPoint > 100){
                    continue;
                }
                if(!visited[nextPoint - 1]) {
                    visited[nextPoint - 1] = true;

                    if (moveInfo.containsKey(nextPoint)) {
                        queue.add(new Point(moveInfo.get(nextPoint), nextCnt));
                        continue;
                    }

                    queue.add(new Point(nextPoint, nextCnt));
                }
            }
        }
    }
}

class Point{
    int curPoint;
    int cnt;

    public Point(int curPoint, int cnt) {
        this.curPoint = curPoint;
        this.cnt = cnt;
    }
}