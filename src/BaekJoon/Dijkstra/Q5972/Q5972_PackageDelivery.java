package BaekJoon.Dijkstra.Q5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5972_PackageDelivery {

    public static int N;        // 헛간의 개수
    public static int M;        // 길의 개수
    public static int[] feed;   // 각 헛간까지의 먹이주는 량
    public static LinkedList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new LinkedList[N];
        feed = new int[N];
        Arrays.fill(feed, Integer.MAX_VALUE);

        for(int idx = 0; idx < N; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int feed = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, feed));
            adj[end].add(new Node(srt, feed));
        }

        dijkstra();
        System.out.println(feed[N - 1]);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.feed - b.feed);

        pQueue.add(new Node(0, 0));
        feed[0] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();

            if(feed[curNode.end] < curNode.feed){
                continue;
            }

            Iterator<Node> it = adj[curNode.end].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int newFeed = curNode.feed + linkedNode.feed;

                if(feed[linkedNode.end] > newFeed){
                    feed[linkedNode.end] = newFeed;
                    pQueue.add(new Node(linkedNode.end, newFeed));
                }
            }
        }
    }
}

class Node{
    int end;
    int feed;

    public Node(int end, int feed) {
        this.end = end;
        this.feed = feed;
    }
}