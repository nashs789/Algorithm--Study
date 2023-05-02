package BaekJoon.Sorting.Q11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11651_SortingCoordinate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        PriorityQueue<Coor> pQueue = new PriorityQueue<>(new Comparator<Coor>() {
            @Override
            public int compare(Coor o1, Coor o2) {
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
        });

        for(int idx = 0; idx < cnt; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pQueue.add(new Coor(x, y));
        }

        while (!pQueue.isEmpty()){
            Coor coor = pQueue.poll();

            sb.append(coor.x).append(' ').append(coor.y).append('\n');
        }

        System.out.println(sb);
    }
}

class Coor{
    int x;
    int y;

    Coor(int x, int y){
        this.x = x;
        this.y = y;
    }
}