package BaekJoon.Greedy.Q1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1715_SortingCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int idx = 0; idx < N; idx++){
            pQueue.offer(Integer.parseInt(br.readLine()));
        }

        while(pQueue.size() != 1){
            int num1 = pQueue.poll();
            int num2 = pQueue.poll();

            answer += num1 + num2;
            pQueue.offer(num1 + num2);
        }

        System.out.println(answer);
    }
}

// 12:30 - 1:30
// 12:00 -
