package BaekJoon.Dijkstra.Q14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14938_BattleGround {

    public static final int MAX_DISTANCE = 10000;
    public static final int MIN_ITEMS = 0;

    public static int n;
    public static int m;
    public static int f;
    public static int[] items;
    public static int[] dist;
    public static LinkedList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = MIN_ITEMS;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        dist = new int[n];
        adj = new LinkedList[n];
        // 각 노드의 아이템 갯수
        items = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int idx = 0; idx < n; idx++){
            adj[idx] = new LinkedList<>();
        }

        // 양뱡향 노드 구성
        for(int idx = 0; idx < f; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            adj[srt].add(new Node(end, dist));
            adj[end].add(new Node(srt, dist));
        }

        // 시작하는 지역을 다르게 설정
        for(int i = 0; i < n; i++){
            int sum = 0;
            dijkstra(i);

            for(int j = 0; j < n; j++){
                if(dist[j] <= m){
                    sum += items[j];
                }
            }

            if(sum > answer){
                answer = sum;
            }
        }

        System.out.println(answer);
    }

    public static void dijkstra(int srt){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        Arrays.fill(dist, MAX_DISTANCE);

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
                }
            }
        }
    }
}

class Node{
    int end;
    int dist;

    public Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }
}