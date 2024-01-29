/**
 *  [ 효율성 ]
 *  - 메모리: 45668KB
 *  - 시간 : 212ms
 */

package BaekJoon.QueueAndDeque.Q2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Q2164_Card2_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        IntStream.rangeClosed(1, num).forEach(e -> queue.add(e));

        while (queue.size() != 1){
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}