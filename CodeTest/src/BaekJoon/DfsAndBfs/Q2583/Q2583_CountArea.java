package BaekJoon.DfsAndBfs.Q2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2583_CountArea {

    private static int M;
    private static int N;
    private static int K;
    private static int nodeCnt;
    private static boolean[] nodeMap;
    private static LinkedList<Integer>[] adj;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nodeCnt = M * N;
        nodeMap = new boolean[nodeCnt];
        adj = new LinkedList[nodeCnt];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++){
                for(int k = y1; k < y2; k++){
                    nodeMap[j * M + k] = true;
                }
            }
        }

        linkNode();
        BFS();
    }

    static void linkNode(){
        for(int idx = 0; idx < nodeCnt; idx++){
            adj[idx] = new LinkedList<>();

            // 상
            if(idx - M >= 0){
                adj[idx].add(idx - M);
            }
            // 하
            if(idx + M < nodeCnt){
                adj[idx].add(idx + M);
            }
            // 좌
            if(idx % M != 0 && idx - 1 >= 0){
                adj[idx].add(idx - 1);
            }
            // 우
            if((idx + 1) % M != 0 && idx + 1 <nodeCnt){
                adj[idx].add(idx + 1);
            }
        }
    }

    static void BFS(){
        boolean[] visited = new boolean[nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int areaCnt = 0;
        int areaNodeCnt = 0;

        for(int idx = 0; idx < nodeCnt; idx++){
            if(visited[idx] || nodeMap[idx]){
                continue;
            }

            queue.add(idx);
            visited[idx] = true;
            areaCnt++;
            areaNodeCnt++;

            while(!queue.isEmpty()){
                Iterator<Integer> it = adj[queue.poll()].listIterator();

                while(it.hasNext()){
                    int linkedNode = it.next();

                    while(!visited[linkedNode] && !nodeMap[linkedNode]){
                        areaNodeCnt++;
                        visited[linkedNode] = true;
                        queue.add(linkedNode);
                    }
                }
            }
            list.add(areaNodeCnt);
            areaNodeCnt = 0;
        }

        sb = new StringBuilder();

        sb.append(areaCnt).append("\n");
        list.sort(Comparator.naturalOrder());

        for(int n : list){
            sb.append(n).append(" ");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}