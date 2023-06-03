package BaekJoon.DivisorMultiplePrimeNumber.Q13909;

import java.util.Scanner;

public class Q13909_CloseWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int windowCnt = sc.nextInt();
        boolean[] window = new boolean[windowCnt];

        for(int i = 1; i <= windowCnt; i++){
            int num = i - 1;

            while(num < windowCnt){
                window[num] = !window[num];
                num += i;
            }
        }

        int cnt = 0;

        for(boolean b : window){
            if(b){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
// 이거 정답코드 아님
// 풀이 포기
