package BaekJoon.Dijkstra.Q1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1854_kShortestPath {

    public static int n;    // 도시들의 개수
    public static int m;    // 도시들 사이의 도로의 수
    public static int k;    // k번째 최단거리
    public static LinkedList<Node>[] adj;           // 인접 노드의 정보
    public static PriorityQueue<Integer>[] dist;    // 도시까지의 거리들 모아놓은 콜렉션

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        adj = new LinkedList[n + 1];
        dist = new PriorityQueue[n + 1];

        for(int idx = 1; idx <= n; idx++){
            adj[idx] = new LinkedList<>();
            dist[idx] = new PriorityQueue<>((a, b) -> b - a);
        }

        for(int idx = 0; idx < m; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, dist));
        }

        dijkstra();

        for(int i = 1; i < dist.length; i++){
            if(dist[i].size() != k){
                sb.append(-1).append('\n');
                continue;
            }

            sb.append(dist[i].peek()).append('\n');
        }

        System.out.print(sb);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pQueue.add(new Node(1, 0));
        dist[1].add(0);

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(dist[curNode.end].peek() < curNode.dist){
                continue;
            }

            Iterator<Node> it = adj[curNode.end].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int newDist = curNode.dist + linkedNode.dist;

                if(dist[linkedNode.end].size() < k){
                    dist[linkedNode.end].add(newDist);
                    pQueue.add(new Node(linkedNode.end, newDist));
                } else if(dist[linkedNode.end].peek() > newDist){
                    dist[linkedNode.end].poll();
                    dist[linkedNode.end].add(newDist);
                    pQueue.add(new Node(linkedNode.end, newDist));
                }
            }
        }
    }
}

class Node{
    int end;
    int dist;

    Node(int end, int dist){
        this.end = end;
        this.dist = dist;
    }
}