package BaekJoon.DfsAndBfs.Q5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014_StartLink {

    private static int F = 0;   // 건물의 전체 층수
    private static int S = 0;   // 현재 층수
    private static int G = 0;   // 가고싶은 층수
    private static int U = 0;   // 한번에 위로 올라가는 층수
    private static int D = 0;   // 한번에 아래로 내려가는 층수
    private static boolean[] visited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
        distance = new int[F + 1];

        BFS();
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean endFlag = false;

        queue.add(S);
        visited[S] = true;

        while(!queue.isEmpty()){
            int curFloor = queue.poll();
            int up = curFloor + U;
            int down = curFloor - D;

            // 가고싶은 층에 도달한 경우
            if(curFloor == G){
                System.out.println(distance[curFloor]);
                endFlag = true;
                break;
            }

            // 최대 층수를 넘어가지 않음 && 방문하지 않음
            if(up <= F && !visited[up]){
                queue.add(up);
                visited[up] = true;
                distance[up] = distance[curFloor] + 1;
            }

            // 1층 이상 && 방문하지 않음
            if(down > 0 && !visited[down]){
                queue.add(down);
                visited[down] = true;
                distance[down] = distance[curFloor] + 1;
            }
        }

        if(!endFlag){
            System.out.println("use the stairs");
        }
    }
}