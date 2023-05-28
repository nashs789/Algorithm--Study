package BaekJoon.Dijkstra.Q1719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1719_Package {

    public static final int MAX = 10000000;

    public static int n;
    public static int m;
    public static int[] dist;               // 다익스트라 알고리즘을 위한 최단거리 기록
    public static int[] singleMap;          // 최단거리 기록시 루트 노드
    public static LinkedList<Node>[] adj;   // 인접노드 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        singleMap = new int[n + 1];
        dist = new int[n + 1];
        adj = new LinkedList[n + 1];

        for(int idx = 1; idx <= n; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < m; idx++){
            st = new StringTokenizer(br.readLine());

            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, dist));
            adj[end].add(new Node(srt, dist));
        }

        // 선언부 end

        for(int i = 1; i <= n; i++){
            dijkstra(i);

            for(int j = 1; j <= n; j++){
                int num = singleMap[j];

                if(num == 0){
                    sb.append('-');
                } else {
                    sb.append(num);
                }

                sb.append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void dijkstra(int srt){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        Arrays.fill(dist, MAX);
        Arrays.fill(singleMap, 0);

        // 가장 처음 시작하는 노드의 인접 노드가 최단거리 도착지점의 루트 노드가 된다
        // ex) 1 - 3, 5, 6 ===> 3, 5, 6이 뿌리 노드가 되어 최단 거리는 뿌리 노드로부터 이어진다
        Iterator<Node> it = adj[srt].iterator();
        dist[srt] = 0;

        while (it.hasNext()){
            Node linkedNode = it.next();

            dist[linkedNode.end] = linkedNode.dist;
            singleMap[linkedNode.end] = linkedNode.end;

            pQueue.add(new Node(linkedNode.end, linkedNode.dist, linkedNode.end));
        }

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(dist[curNode.end] < curNode.dist){
                continue;
            }

            it = adj[curNode.end].iterator();

            while (it.hasNext()){
                Node linkedNode = it.next();
                int newDist = curNode.dist + linkedNode.dist;

                if(dist[linkedNode.end] > newDist){
                    dist[linkedNode.end] = newDist;
                    singleMap[linkedNode.end] = curNode.root;
                    pQueue.add(new Node(linkedNode.end, newDist, curNode.root));
                }
            }
        }
    }
}

class Node{
    int end;
    int dist;
    int root;

    public Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }

    public Node(int end, int dist, int root) {
        this.end = end;
        this.dist = dist;
        this.root = root;
    }
}