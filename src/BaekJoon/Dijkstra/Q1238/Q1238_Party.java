package BaekJoon.Dijkstra.Q1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1238_Party {

    public static final int MAX = 10000000;
    
    public static int N;
    public static int M;
    public static int X;
    public static int[] dist;
    public static int[] distSum;
    public static LinkedList<Node>[] adj;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        distSum = new int[N + 1];
        adj = new LinkedList[N + 1];

        for(int idx = 0; idx < adj.length; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(end, dist));
        }

        for(int idx = 1; idx < dist.length; idx++){
            if(idx == X){
                continue;
            }

            dijkstra(idx);
            distSum[idx] += dist[X];
        }

        dijkstra(X);

        for(int idx = 1; idx < dist.length; idx++){
            distSum[idx] += dist[idx];
        }

        System.out.println(Arrays.stream(distSum).max().getAsInt());
    }
    
    public static void dijkstra(int srt){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a1, a2) -> a1.dist - a2.dist);
        initDistance();

        pQueue.add(new Node(srt, 0));
        dist[srt] = 0;

        while (!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(dist[curNode.target] < curNode.dist){
                continue;
            }

            Iterator<Node> it = adj[curNode.target].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int newDist = linkedNode.dist + curNode.dist;

                if(dist[linkedNode.target] > newDist){
                    dist[linkedNode.target] = newDist;
                    pQueue.add(new Node(linkedNode.target, newDist));

                }
            }
        }
    }

    public static void initDistance(){
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