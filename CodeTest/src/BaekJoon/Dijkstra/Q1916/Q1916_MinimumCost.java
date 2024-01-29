package BaekJoon.Dijkstra.Q1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1916_MinimumCost {

    private static int cities = 0;          // 1 <= 도시의 개수 <= 1000
    private static int buses = 0;           // 1 <= 버스의 개수 <= 100000
    private static int strNode = 0;         // 시작 노드 번호
    private static int endNode = 0;         // 종료 노드 번호
    private static LinkedList<Node>[] adj;  // 인접 노드 정보
    private static int[] cost;              // 비용 정보
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cities = Integer.parseInt(br.readLine()) + 1;
        buses = Integer.parseInt(br.readLine());
        adj = new LinkedList[cities];
        cost = new int[cities];

        for(int idx = 1; idx < cost.length; idx++){
            adj[idx] = new LinkedList<>();
            cost[idx] = Integer.MAX_VALUE;
        }

        for(int idx = 0; idx < buses; idx++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        strNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(cost[endNode]);
    }

    static void dijkstra(){
        boolean[] visited = new boolean[cities];
        Queue<Node> queue = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

        queue.add(new Node(strNode, 0));
        cost[strNode] = 0;

        while (!queue.isEmpty()){
            Node curNode = queue.poll();

            if(!visited[curNode.no]){
                visited[curNode.no] = true;
            }

            Iterator<Node> it = adj[curNode.no].listIterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int sumCost = curNode.cost + linkedNode.cost;

                if(cost[linkedNode.no] > sumCost){
                    cost[linkedNode.no] = sumCost;
                    if(queue.contains(linkedNode)){
                        queue.remove(linkedNode);
                    }
                    queue.add(new Node(linkedNode.no, sumCost));
                }
            }
        }
    }
}

class Node{
    int no;
    int cost;

    Node(int no, int cost){
        this.no = no;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj){
        return this.no == ((Node) obj).no;
    }
}