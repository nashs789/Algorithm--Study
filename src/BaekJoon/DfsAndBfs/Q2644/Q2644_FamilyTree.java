package BaekJoon.DfsAndBfs.Q2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644_FamilyTree {

    private static int n;
    private static int str;
    private static int end;
    private static int cnt;

    private static LinkedList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) + 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(br.readLine());
        adj = new LinkedList[n];

        for(int idx = 1; idx < n; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < cnt; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        BFS();
    }

    static void BFS(){
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean flag = false;

        queue.add(str);
        visited[str] = true;

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            Iterator<Integer> it = adj[curNode].listIterator();

            if(curNode == end){
                System.out.println(distance[curNode]);
                flag = true;
                break;
            }

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    queue.add(linkedNode);
                    visited[linkedNode] = true;
                    distance[linkedNode] = distance[curNode] + 1;
                }
            }
        }

        if(!flag){
            System.out.println(-1);
        }
    }
}