package BaekJoon.Dijkstra.Q1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q1967_RadiusOfTree {

    public static int nodeCnt;
    public static int longest = 0;
    public static int longestNode;
    public static int[] dist;
    public static LinkedList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCnt = Integer.parseInt(br.readLine());
        adj = new LinkedList[nodeCnt + 1];

        if(nodeCnt != 1){
            for(int idx = 1; idx < adj.length; idx++){
                adj[idx] = new LinkedList<>();
            }

            for(int i = 0; i < nodeCnt - 1; i++){
                int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int srt = info[0];    // 주체 노드
                int end = info[1];    // 목적지 노드
                int dist = info[2];   // 가중치

                adj[srt].add(new Node(end, dist));
                adj[end].add(new Node(srt, dist));
            }

            dijkstra(1);
            dijkstra(longestNode);
        }

        System.out.println(longest);
    }

    public static void dijkstra(int srt){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist = new int[nodeCnt + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pQueue.add(new Node(srt, 0));
        dist[srt] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(dist[curNode.end] < curNode.dist){
                continue;
            }

            Iterator<Node> it = adj[curNode.end].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int newDist = curNode.dist + linkedNode.dist;

                if(dist[linkedNode.end] > newDist){
                    dist[linkedNode.end] = newDist;
                    pQueue.add(new Node(linkedNode.end, newDist));

                    if(longest < newDist){
                        longest = newDist;
                        longestNode = linkedNode.end;
                    }
                }
            }
        }
    }
}

class Node{
    int end;    // 노드 관계에서 목적지 노드 번호
    int dist;

    public Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }
}