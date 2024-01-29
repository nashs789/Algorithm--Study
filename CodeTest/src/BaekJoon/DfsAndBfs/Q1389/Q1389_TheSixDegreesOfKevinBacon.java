package BaekJoon.DfsAndBfs.Q1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1389_TheSixDegreesOfKevinBacon {

    private static int friends = 0;
    private static int relationShip = 0;
    private static LinkedList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        friends = Integer.parseInt(st.nextToken()) + 1;
        relationShip = Integer.parseInt(st.nextToken());
        adj = new LinkedList[friends];

        for(int idx = 1; idx < friends; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 1; idx <= relationShip; idx++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        BFS();
    }

    static void BFS(){
        boolean[] visited;
        int[] distance;
        Queue<Integer> queue = new LinkedList<>();
        int[] countArr;
        int peopleNo = 0;
        int sum = 101;

        for(int i = 1; i < friends; i++){
            visited = new boolean[friends];
            countArr = new int[friends];
            distance = new int[friends];
            queue.add(i);
            visited[i] = true;

            while(!queue.isEmpty()){
                int curNode = queue.poll();
                Iterator<Integer> it = adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkedList = it.next();

                    if(!visited[linkedList]){
                        visited[linkedList] = true;
                        queue.add(linkedList);
                        distance[linkedList] = distance[curNode] + 1;
                        countArr[linkedList] = distance[linkedList];
                    }
                }
            }
            int tempSum = Arrays.stream(countArr).sum();

            if(sum > tempSum){
                sum = tempSum;
                peopleNo = i;
            }
        }

        System.out.println(peopleNo);
    }
}