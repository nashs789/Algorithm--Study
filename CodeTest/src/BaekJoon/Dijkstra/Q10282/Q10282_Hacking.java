package BaekJoon.Dijkstra.Q10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10282_Hacking {

    public static final int MAX_SECOND = 1000000000;

    public static int n;    // 컴퓨터 개수
    public static int d;    // 의존성 개수
    public static int c;    // 해킹당한 컴퓨터의 번호
    public static int[] sec;
    public static LinkedList<Node>[] adj;
    public static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken()) - 1;

            sec = new int[n];
            Arrays.fill(sec, MAX_SECOND);
            adj = new LinkedList[n];

            for(int j = 0; j < n; j++){
                adj[j] = new LinkedList<>();
            }

            for(int j = 0; j < d; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;   // 의존 하는 객체
                int b = Integer.parseInt(st.nextToken()) - 1;   // 의존 당하는 객체
                int s = Integer.parseInt(st.nextToken());       // 도달하는데 걸리는 시간

                adj[b].add(new Node(a, s));
            }

            dijkstra(c);
            sb.append(set.size())
              .append(' ')
              .append(Arrays.stream(sec)
                            .filter(e -> e != MAX_SECOND)
                            .max()
                            .getAsInt())
              .append('\n');
        }
        System.out.println(sb);
    }

    public static void dijkstra(int srt){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a, b) -> a.sec - b.sec);
        set = new HashSet<>();

        pQueue.add(new Node(srt, 0));
        sec[srt] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();
            set.add(curNode.com);

            if(sec[curNode.com] < curNode.sec){
                continue;
            }

            Iterator<Node> it = adj[curNode.com].iterator();

            while(it.hasNext()){
                Node linkedNode = it.next();
                int newSec = curNode.sec + linkedNode.sec;

                if(sec[linkedNode.com] > newSec){
                    sec[linkedNode.com] = newSec;
                    pQueue.add(new Node(linkedNode.com, newSec));
                }
            }
        }
    }
}

class Node{
    int com;
    int sec;

    public Node(int com, int sec) {
        this.com = com;
        this.sec = sec;
    }
}