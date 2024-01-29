package BaekJoon.DfsAndBfs.Q9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9205_DrinkingBeerWalking {

    public static int t;    // 테스트 케이스
    public static int n;    // 편의점 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());

            List<Vertex> list = new ArrayList<>();
            LinkedList<Integer>[] adj = new LinkedList[n + 2];

            for(int i = 0; i < n + 2; i++){
                adj[i] = new LinkedList<>();
            }

            for(int i = 0; i < n + 2; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Vertex(x, y));
            }

            for(int i = 0; i < n + 2; i++){
                for(int j = i + 1; j < n + 2; j++){
                    if(Manhattan(list.get(i), list.get(j)) <= 1000){
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }

            sb.append(bfs(adj) ? "happy" : "sad").append("\n");
        }
        System.out.print(sb);
    }

    public static int Manhattan(Vertex v1, Vertex v2){
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    public static boolean bfs(LinkedList<Integer>[] adj){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int curV = queue.poll();

            if(curV == n + 1){
                return true;
            }

            for(int linkedV : adj[curV]){
                if(!visited[linkedV]){
                    visited[linkedV] = true;
                    queue.add(linkedV);
                }
            }
        }

        return false;
    }
}

class Vertex{
    int x;
    int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
