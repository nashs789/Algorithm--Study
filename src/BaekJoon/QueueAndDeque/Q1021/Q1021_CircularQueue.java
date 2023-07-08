package BaekJoon.QueueAndDeque.Q1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021_CircularQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();
        int total = Integer.parseInt(st.nextToken());
        int targetCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for(int idx = 1; idx <= total; idx++) {
            deque.addLast(idx);
        }

        while(st.hasMoreTokens()) {
            int targetNum = Integer.parseInt(st.nextToken());
            int halfIdx = deque.size() / 2;
            int targetLoc = deque.indexOf(targetNum);

            while (deque.peekFirst() != targetNum) {
                if (halfIdx >= targetLoc) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
                answer++;
            }
            deque.pollFirst();
        }

        System.out.println(answer);
    }
}