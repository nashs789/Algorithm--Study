/**
 *  [ 효율성 ]
 *  - 메모리: 16088KB
 *  - 시간 : 160ms
 */

package BaekJoon.DfsAndBfs.Q2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644_FamilyTree_sol2 {

    public static int N;    // 전체 사람의 수
    public static int M;    // 관계의 수
    public static int srt;  // 촌수 찾기 시작
    public static int end;  // 촌수 찾기 타겟
    public static LinkedList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        srt = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        adj = new LinkedList[N + 1];

        for(int idx = 0; idx < N + 1; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[srt].add(end);
            adj[end].add(srt);
        }

        bfs();
        System.out.println(-1);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(new Node(srt, 0));
        visited[srt] = true;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            if(curNode.srt == end){
                System.out.println(curNode.dist);
                System.exit(0);
            }

            Iterator<Integer> it = adj[curNode.srt].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    visited[linkedNode] = true;
                    queue.add(new Node(linkedNode, curNode.dist + 1));
                }
            }
        }
    }
}

class Node{
    int srt;
    int dist;

    public Node(int srt, int dist) {
        this.srt = srt;
        this.dist = dist;
    }
}