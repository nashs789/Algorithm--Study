package BaekJoon.Dijkstra.Q9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9370_UnsureDestination {

    public static int n;    // 교차로의 개수
    public static int m;    // 도로의 개수
    public static int t;    // 목적지 후보의 개수
    public static int s;    // 출발지
    public static int g;    // 지나간 도로의 약 쪽 교차로 중 하나
    public static int h;    // 지나간 도로의 약 쪽 교차로 중 하나

    public static int[] candidate;
    public static int[] dist1;
    public static int[] dist2;
    public static int[] dist3;
    public static LinkedList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int idx = 0; idx < testCase; idx++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            candidate = new int[t];
            dist1 = new int[n + 1];
            dist2 = new int[n + 1];
            dist3 = new int[n + 1];
            Arrays.fill(dist1, Integer.MAX_VALUE);
            Arrays.fill(dist2, Integer.MAX_VALUE);
            Arrays.fill(dist3, Integer.MAX_VALUE);
            adj = new LinkedList[n + 1];

            for(int i = 0; i <= n; i++){
                adj[i] = new LinkedList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, d));
                adj[b].add(new Node(a, d));
            }

            for(int i = 0; i < t; i++){
                candidate[i] = Integer.parseInt(br.readLine());
            }

            int secondDestination = Integer.MAX_VALUE;
            int thirdDestination = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<>();

            dijkstra(s, dist1);
            secondDestination = dist1[g] < dist1[h] ? g : h;
            thirdDestination = dist1[g] > dist1[h] ? g : h;

            dijkstra(secondDestination, dist2);
            dijkstra(thirdDestination, dist3);

            for(int i = 0; i < candidate.length; i++){
                int distOfPath = dist1[secondDestination] + dist2[thirdDestination] + dist3[candidate[i]];

                if(dist1[candidate[i]] == distOfPath){
                    list.add(candidate[i]);
                }
            }

            list.sort(Comparator.naturalOrder());

            for(int n : list){
                sb.append(n).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void dijkstra(int srt, int[] dist){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);

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
                    Node nextNode = new Node(linkedNode.end, newDist, curNode.end);

                    dist[linkedNode.end] = newDist;
                    pQueue.add(nextNode);
                }
            }
        }
    }
}

class Node{
    int end;
    int dist;
    int lastNode;

    public Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }

    public Node(int end, int dist, int lastNode) {
        this.end = end;
        this.dist = dist;
        this.lastNode = lastNode;
    }
}