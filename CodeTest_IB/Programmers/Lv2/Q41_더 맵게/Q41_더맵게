package Programmers.Lv2.Q41;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q41_Spicier {
    public static void main(String[] args) {
        int[] scoville = {1, 1};
        int K = 3;
        int answer = 0;
        PriorityQueue<Integer> queue = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        Arrays.sort(scoville);

        while(true){
            int min1 = queue.poll();

            if(min1 >= K){
                break;
            }

            int min2 = queue.poll();

            queue.add(min1 + (min2 * 2));
            answer++;

            if(queue.size() == 1 && queue.peek() < K){
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }
}