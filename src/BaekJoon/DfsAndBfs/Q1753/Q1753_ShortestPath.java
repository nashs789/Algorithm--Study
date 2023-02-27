package BaekJoon.DfsAndBfs.Q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753_ShortestPath {

    private static int startV = 0;
    private static int vertex = 0;
    private static int edge = 0;
    private static LinkedList<Node>[] adj;
    private static boolean[] visited;
    private static int[] distance;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken()) + 1;
        edge = Integer.parseInt(st.nextToken());
        startV  = Integer.parseInt(br.readLine());
        adj = new LinkedList[vertex];
        visited = new boolean[vertex];
        distance = new int[vertex];

        for(int idx = 1; idx < vertex; idx++){
            adj[idx] = new LinkedList<>();
            distance[idx] = Integer.MAX_VALUE;
        }

        for(int idx = 0; idx < edge; idx++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, dist));
        }

        dijkstra();

        for(int idx = 1; idx < vertex; idx++){
            sb.append(distance[idx] == Integer.MAX_VALUE ? "INF" : distance[idx]).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    static void dijkstra(){
        Queue<Node> queue = new PriorityQueue<>((e1, e2) -> e1.distance - e2.distance);

        queue.add(new Node(startV, 0));
        distance[startV] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            if(!visited[curNode.vertex]){
                visited[curNode.vertex] = true;
            }

            Iterator<Node> it = adj[curNode.vertex].listIterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int sumDist = curNode.distance + linkedNode.distance;

                if(!visited[linkedNode.vertex] && distance[linkedNode.vertex] > sumDist){
                    distance[linkedNode.vertex] = sumDist;
                    queue.add(new Node(linkedNode.vertex, sumDist));
                }
            }
        }
    }
}

class Node{
    int vertex;
    int distance;

    Node(int vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }
}
// 3:50 - 48
// 5:07- 57