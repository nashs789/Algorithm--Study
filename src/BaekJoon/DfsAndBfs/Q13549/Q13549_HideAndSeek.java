package BaekJoon.DfsAndBfs.Q13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13549_HideAndSeek {

    public static int N;
    public static int K;
    public static boolean[] visited = new boolean[100001];
    public static int[] time = new int[100001];
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // 수빈이의 위치
        K = Integer.parseInt(st.nextToken());    // 동생의 위치

        bfs();

        System.out.println(time[K]);
    }

    public static void bfs() {
        Node firstNode = new Node(N, 0);

        queue.add(firstNode);
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node curLoc = queue.poll();

            int prev = curLoc.point - 1;
            int next = curLoc.point + 1;
            int tp = curLoc.point * 2;

            chkVisited(tp, curLoc.time);
            chkVisited(prev, curLoc.time + 1);
            chkVisited(next, curLoc.time + 1);
        }
    }

    public static void chkVisited(int point, int nextTime){
        Node nextNode = new Node(point, nextTime);

        if(0 <= point && point < visited.length) {
            if(!visited[point] || time[point] > nextTime){
                visited[point] = true;
                time[point] = nextTime;
                queue.add(nextNode);
            }
        }
    }
}

class Node{
    int point;
    int time;

    Node(int p, int t){
        this.point = p;
        this.time = t;
    }
}