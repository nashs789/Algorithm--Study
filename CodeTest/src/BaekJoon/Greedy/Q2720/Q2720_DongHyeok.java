package BaekJoon.Greedy.Q2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2720_DongHyeok {

    public static int[] type = {25, 10, 5, 1};
    public static int[] rest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int money = Integer.parseInt(br.readLine());
            rest = new int[4];

            for(int j = 0; j < type.length; j++){
                rest[j] = money / type[j];
                money %= type[j];
            }

            for(int cnt : rest){
                sb.append(cnt + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}