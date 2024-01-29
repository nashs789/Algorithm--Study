package BaekJoon.DfsAndBfs.Q16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16928_SnakeAndLadder_sol2 {

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
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0});
        visited[0] = true;

        while (!queue.isEmpty()){
            int[] p = queue.poll();

            if(p[0] == 100){
                System.out.println(p[1]);
                break;
            }

            // 주사위 1 ~ 6 까지
            for(int idx = 1; idx <= 6; idx++){
                int nextPoint = p[0] + idx;
                int nextCnt = p[1] + 1;

                if(nextPoint > 100){
                    continue;
                }

                if(!visited[nextPoint - 1]){
                    visited[nextPoint - 1] = true;

                    if(moveInfo.containsKey(nextPoint)){
                        queue.add(new int[]{moveInfo.get(nextPoint), nextCnt});
                        continue;
                    }

                    queue.add(new int[]{nextPoint, nextCnt});
                }
            }
        }
    }
}