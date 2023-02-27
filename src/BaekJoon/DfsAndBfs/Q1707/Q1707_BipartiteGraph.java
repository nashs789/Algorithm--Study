package BaekJoon.DfsAndBfs.Q1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1707_BipartiteGraph {

    private static StringBuilder sb = new StringBuilder();
    private static LinkedList<Integer>[] adj;
    private static int vertex = 0;
    private static int edge = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCaseCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken()) + 1;  // 문제에서 1 <= V <= 20000
            edge = Integer.parseInt(st.nextToken());        // 문제에서 1 <= E <= 200000
            adj = new LinkedList[vertex];

            for(int j = 1; j < vertex; j++){
                adj[j] = new LinkedList<>();
            }

            for(int j = 0; j < edge; j++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
                adj[to].add(from);
            }

            BFS();
        }

        System.out.print(sb);
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        int[] bipartite = new int[vertex];  // 0: 미방문,  1: 그룹1,  2: 그룹2
        boolean flag = false;               // true: 이분 그래프 x, false: 이분 그래프

        Loop1:
        for(int idx = 1; idx < vertex; idx++){
            if(bipartite[idx] != 0){
                continue;
            }

            queue.add(idx);
            bipartite[idx] = 1;

            while (!queue.isEmpty()){
                int curNode = queue.poll();
                int curGroup = bipartite[curNode];

                Iterator<Integer> it = adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkedNode = it.next();

                    // 인접 노드가 같은 그룹에 속한 경우
                    if(curGroup == bipartite[linkedNode]){
                        flag = true;
                        break Loop1;
                    }

                    // 방문을 하지 않은경우
                    if(bipartite[linkedNode] == 0){
                        bipartite[linkedNode] = curGroup == 1 ? 2 : 1;
                        queue.add(linkedNode);
                    }
                }
            }
        }

        if(flag){
            sb.append("NO").append("\n");
        } else {
            sb.append("YES").append("\n");
        }
    }
}