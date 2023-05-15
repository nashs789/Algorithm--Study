package BaekJoon.QueueAndDeque.Q2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q2164_Card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int idx = 1;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        IntStream.rangeClosed(1, num).forEach(e -> queue.add(e));

        while (queue.size() != 1){
            while(!queue.isEmpty()){
                if(idx++ % 2 == 1){
                    queue.poll();
                } else {
                    tempQueue.add(queue.poll());
                }
            }

            while (!tempQueue.isEmpty()){
                queue.add(tempQueue.poll());
            }
            tempQueue.clear();
        }

        System.out.println(queue.poll());
    }
}