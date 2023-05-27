package BaekJoon.Dijkstra.Q11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11779_MinimumCost2 {

    public static int MAX = Integer.MAX_VALUE;

    public static int n;                    // 노드의 개수
    public static int m;                    // 간선의 개수
    public static int from;                 // 출발지
    public static int to;                   // 도착지
    public static Node[] path;              // 경로
    public static int[] dist;               // 최소거리
    public static LinkedList<Node>[] adj;   // 인접 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        path = new Node[n + 1];
        adj = new LinkedList[n + 1];
        Arrays.fill(dist, MAX);

        for(int idx = 0; idx < adj.length; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < m; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());

        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        // 입력 및 초기화 끝

        dijkstra();

        System.out.println(dist[to]);
        System.out.println(path[to].path.toString().split(" ").length);
        System.out.println(path[to].path);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a1, a2) -> a1.cost - a2.cost);

        Node srtNode = new Node(from, 0);

        pQueue.add(srtNode);
        dist[from] = 0;
        path[from] = srtNode;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();
            curNode.addPath(curNode.end);

            if(dist[curNode.end] < curNode.cost){
                continue;
            }

            Iterator<Node> it = adj[curNode.end].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int newCost = curNode.cost + linkedNode.cost;

                if(dist[linkedNode.end] > newCost){
                    Node nextNode = new Node(linkedNode.end, newCost);

                    nextNode.addPath(curNode.path);
                    dist[linkedNode.end] = newCost;
                    path[linkedNode.end] = nextNode;
                    pQueue.add(nextNode);
                }
            }
        }
    }
}

class Node {
    int end;
    int cost;
    StringBuilder path = new StringBuilder();

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    public void addPath(StringBuilder sb){
        this.path = new StringBuilder(sb);
    }

    public void addPath(int nodeNum){
        path.append(nodeNum).append(' ');
    }
}