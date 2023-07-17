/**
 *  [ 효율성 ]
 *  - 메모리: 14404KB
 *  - 시간 : 140ms
 */



import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Q1021_queue {
    static int count;
    static LinkedList<Integer> list;

    public static void search(int num) {
        if (list.peekFirst() == num) {
            list.pollFirst();
        }
        else {
            int target = list.indexOf(num);
            while (list.peekFirst() != num) {
                count++;
                if (target > list.size() / 2) {
                    list.addFirst(list.pollLast());
                }
                else {
                    list.addLast(list.pollFirst());
                }
            }
            list.pollFirst();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = IntStream.rangeClosed(1, n)
                      .boxed()
                      .collect(Collectors.toCollection(LinkedList::new));
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            search(num);
        }
        System.out.println(count);
    }
}

