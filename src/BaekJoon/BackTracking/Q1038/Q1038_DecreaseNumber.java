package BaekJoon.BackTracking.Q1038;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1038_DecreaseNumber {

    public static int N;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if(N <= 10) System.out.println(N);
        else if(N > 1022) System.out.println("-1");
        else {
            for(int i = 0; i < 10; i++) {
                backtracking(i, 1);
            }
            Collections.sort(list);

            System.out.println(list.get(N));
        }
    }

    public static void backtracking(long num, int idx){
        if(idx > 10) {
            return;
        }

        list.add(num);

        for(int i = 0; i < num % 10; i++) {
            backtracking((num * 10) + i, idx + 1);
        }
    }
}

// 2:57 - 4:27
// 4:47 - 5:25
// 이건 진짜 못풀겠네... 다른 사람꺼 보고함