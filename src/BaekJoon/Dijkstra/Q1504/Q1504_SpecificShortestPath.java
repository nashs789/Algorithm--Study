package BaekJoon.Dijkstra.Q1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504_SpecificShortestPath {

    public static int N;
    public static int E;
    public static int dist[];
    public static LinkedList<Node>[] adj;
    public static final int MAX = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new LinkedList[N + 1];
        dist = new int[N + 1];

        for(int idx = 1; idx <= N; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < E; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, dist));
            adj[end].add(new Node(srt, dist));
        }

        st = new StringTokenizer(br.readLine());

        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());
        int AtoB = 0;
        int BtoA = 0;

        dijkstra(1);
        AtoB += dist[targetA];
        BtoA += dist[targetB];

        dijkstra(targetA);
        AtoB += dist[targetB];
        BtoA += dist[targetB] + dist[N];

        dijkstra(targetB);
        AtoB += dist[N];

        int min = Math.min(AtoB, BtoA);

        if(min >= MAX){
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void dijkstra(int target){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        initDistanceArray();

        pQueue.add(new Node(target,0));
        dist[target] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(dist[curNode.target] < curNode.dist){
                continue;
            }

            Iterator<Node> it = adj[curNode.target].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();

                if(dist[linkedNode.target] > curNode.dist + linkedNode.dist){
                    pQueue.add(new Node(linkedNode.target, curNode.dist + linkedNode.dist));
                    dist[linkedNode.target] = curNode.dist + linkedNode.dist;
                }
            }
        }
    }

    public static void initDistanceArray(){
        Arrays.fill(dist, MAX);
    }
}

class Node{
    int target;
    int dist;

    public Node(int target, int dist) {
        this.target = target;
        this.dist = dist;
    }
}