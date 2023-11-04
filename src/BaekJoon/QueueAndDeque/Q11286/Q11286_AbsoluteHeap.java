/**
* Author    : Lee In Bok 
* Date      : 2023.11.05(Sat)
* Spend Time: 34m 23s
* Runtime   : 316 ms
* Memory    : 25280 KB
* Algoritm  : Heap
 */

package BaekJoon.QueueAndDeque.Q11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q11286_AbsoluteHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.abs == p2.abs){
                    return p1.org - p2.org;
                }
                return p1.abs - p2.abs;
            }
        });
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll().org).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                queue.add(new Pair(Math.abs(num), num));
            }
        }

        System.out.println(sb);
    }
}

class Pair{
    int abs;
    int org;

    Pair(int abs, int org){
        this.abs = abs;
        this.org = org;
    }
}