package BaekJoon.Tree.Q1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Q1068_Tree {

    public static List<List<Integer>> adj;
    public static boolean[] visited;
    public static int leafNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int deleteNode = Integer.parseInt(br.readLine());
        int root = 0;
        visited = new boolean[nodeCnt];

        adj = new ArrayList<>(nodeCnt);

        for(int idx = 0; idx < nodeCnt; idx++){
            adj.add(new ArrayList<>());
        }

        for(int idx = 0; idx < nodeCnt; idx++){
            int parent = Integer.parseInt(st.nextToken());

            // 루트 노드인 경우 루트 노드가 어떤 번호인지 기억한다.
            if(parent == -1){
                root = idx;
                continue;
            }

            // 삭제될 노드 || 삭제될 노드를 부모로 갖는 노드 노드 생성 안한다
            // (삭제될 노드를 부모로 갖는건 모름 하지만 dfs 알고리즘 탐색에 포함되지는 않는다 == 연결되어 있지 않음)
            if(idx == deleteNode || parent == deleteNode){
                continue;
            }

            adj.get(parent).add(idx);
        }

        // 루트 노드가 삭제되는 노드와 일치하는 경우
        if(root == deleteNode){
            System.out.println(0);
            System.exit(0);
        }

        dfs(root);
        System.out.println(leafNode);
    }

    public static void dfs(int curNode){
        Iterator<Integer> it = adj.get(curNode).listIterator();

        // 더 이상 연결된 노드가 없는 경우 leafNode 로 취급
        if(!it.hasNext()){
            leafNode++;
            return;
        }

        while(it.hasNext()){
            int linkedNode = it.next();

            if(!visited[linkedNode]){
                visited[linkedNode] = true;
                dfs(linkedNode);
            }
        }
    }
}