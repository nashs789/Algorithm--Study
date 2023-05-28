package BaekJoon.SetAndMap.Q1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1764_NoName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pQueue = new PriorityQueue<>();

        int hear = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());

        Set<String> neverHeard = new HashSet<>();

        for(int idx = 0; idx < hear; idx++){
            neverHeard.add(br.readLine());
        }

        for(int idx = 0; idx < see; idx++){
            String neverSaw = br.readLine();

            if(neverHeard.contains(neverSaw)){
                pQueue.add(neverSaw);
            }
        }

        sb.append(pQueue.size()).append('\n');

        while(!pQueue.isEmpty()){
            sb.append(pQueue.poll()).append('\n');
        }

        System.out.println(sb);
    }
}