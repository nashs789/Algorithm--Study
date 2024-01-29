package BaekJoon.BackTracking.Q10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10971_TravellingSalesmanProblem {

    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static LinkedList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        adj = new LinkedList[N];

        for(int idx = 0; idx < N; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                int cost = Integer.parseInt(st.nextToken());

                if(cost != 0){
                    adj[i].add(new Node(j, cost));
                }
            }
        }

        backTracking(0, 0, 1);
        System.out.println(min);
    }

    public static void backTracking(int nodeNum, int sum, int cnt){
        if(cnt == N){
            int lastDesIdx = adj[nodeNum].indexOf(new Node(0, 0));

            // 출발 위치로 돌아갈 수 없는 케이스
            if(lastDesIdx == -1){
                return;
            }

            // 출발 위치 까지의 거리 더해줌
            sum += adj[nodeNum].get(lastDesIdx).cost;
            min = Math.min(min, sum);
            return;
        }

        Iterator<Node> it = adj[nodeNum].iterator();

        while(it.hasNext()){
            Node linkedNode = it.next();
            int next = linkedNode.end;

            // 출발 위치로 가는건 (처음, 마지막) -> 마지막이 아니면 다시
            if(next == 0 && cnt != N){
                continue;
            }

            if(!visited[next]){
                visited[next] = true;
                backTracking(next, sum + linkedNode.cost,cnt + 1);
                visited[next] = false;
            }
        }
    }
}

class Node{
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj){
        Node node = (Node) obj;

        return this.end == node.end;
    }
}