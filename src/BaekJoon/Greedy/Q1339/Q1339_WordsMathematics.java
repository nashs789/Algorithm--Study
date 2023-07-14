package BaekJoon.Greedy.Q1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339_WordsMathematics {

    public static int N;
    public static String[] strArr;
    public static Map<Character, Integer> map;
    public static PriorityQueue<Alpha> pQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        pQueue = new PriorityQueue<>();

        strArr = new String[N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            strArr[i] = s;

            for(int j = 0; j < s.length(); j++){
                int num = (int) Math.pow(10, s.length() - 1 - j);
                char c = s.charAt(j);

                map.put(c, map.getOrDefault(c, 0) + num);
            }
        }

        mapToQueue();
        System.out.print(getSum());
    }

    public static void mapToQueue(){
        Iterator<Character> it = map.keySet().iterator();

        while(it.hasNext()){
            char key = it.next();

            pQueue.add(new Alpha(key, map.get(key)));
        }
    }

    public static int getSum(){
        int num = 9;

        while(!pQueue.isEmpty()){
            Alpha a = pQueue.poll();

            for(int idx = 0; idx < N; idx++){
                strArr[idx] = strArr[idx].replace(Character.toString(a.c), Integer.toString(num));
            }

            num--;
        }

       return Arrays.stream(strArr).mapToInt(Integer::parseInt).sum();
    }
}

class Alpha implements Comparable<Alpha>{
    char c;
    int val;

    public Alpha(char c, int val) {
        this.c = c;
        this.val = val;
    }

    @Override
    public int compareTo(Alpha o) {
        return o.val - this.val;
    }
}