package BaekJoon.BruteForce.Q1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q1436_MovieDirectorShom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int cnt = Integer.parseInt(br.readLine());
        int curCnt = 0;
        int start = 666;

        while(true){
            if(cnt == curCnt){
                break;
            }

            if(Integer.toString(start).contains("666")){
                list.add(start);
                curCnt++;
            }

            start++;
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(cnt - 1));
    }
}