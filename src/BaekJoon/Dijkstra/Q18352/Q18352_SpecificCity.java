package BaekJoon.Dijkstra.Q18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18352_SpecificCity {

    public static int N;    // 도시의 개수
    public static int M;    // 도로의 개수
    public static int K;    // 거리 정보
    public static int X;    // 출발 도시의 번호
    public static int[] dist;
    public static LinkedList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        adj = new LinkedList[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int idx = 0; idx < adj.length; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, 1));
        }

        dijkstra();

        for(int idx = 1; idx <= N; idx++){
            if(dist[idx] == K){
                sb.append(idx).append('\n');
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[X] = 0;
        pQueue.add(new Node(X, dist[X]));

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(dist[curNode.nodeNum] < curNode.dist){
                continue;
            }

            Iterator<Node> it = adj[curNode.nodeNum].listIterator();

            while(it.hasNext()){
                Node linkedNode = it.next();

                if(dist[linkedNode.nodeNum] > curNode.dist + linkedNode.dist){
                    dist[linkedNode.nodeNum] = curNode.dist + linkedNode.dist;
                    pQueue.add(new Node(linkedNode.nodeNum, dist[linkedNode.nodeNum]));
                }
            }
        }
    }
}

class Node {
    int nodeNum;
    int dist;

    Node(int n, int d){
        this.nodeNum = n;
        this.dist = d;
    }
}