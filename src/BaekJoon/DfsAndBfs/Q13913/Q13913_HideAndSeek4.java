package BaekJoon.DfsAndBfs.Q13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13913_HideAndSeek4 {

    public static int N;
    public static int K;
    public static int[] path = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        StringBuilder sb = new StringBuilder();

        int time = 0;
        visited[N] = true;
        queue.add(N);

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                int curV = queue.poll();

                if(curV == K){
                    Stack<Integer> stack = new Stack<>();
                    stack.push(curV);

                    while(curV != N){
                        stack.push(path[curV]);
                        curV = path[curV];
                    }

                    sb.append(time + "\n");
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop() + " ");
                    }

                    System.out.println(sb);
                    return;
                }

                int next1 = curV + 1;
                int next2 = curV - 1;
                int next3 = curV * 2;

                if(isValidCoord(next1) && !visited[next1]){
                    queue.add(next1);
                    visited[next1] = true;
                    path[next1] = curV;
                }

                if(isValidCoord(next2) && !visited[next2]){
                    queue.add(next2);
                    visited[next2] = true;
                    path[next2] = curV;
                }

                if(isValidCoord(next3) && !visited[next3]){
                    queue.add(next3);
                    visited[next3] = true;
                    path[next3] = curV;
                }
            }

            time++;
        }
    }

    public static boolean isValidCoord(int n){
        return 0 <= n && n <= 100000;
    }
}