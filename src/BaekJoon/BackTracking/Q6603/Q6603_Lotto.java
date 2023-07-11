package BaekJoon.BackTracking.Q6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603_Lotto {

    public static StringBuilder sb = new StringBuilder();
    public static int k;
    public static int[] arr;
    public static int[] lotto = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];

            if(k == 0){
                break;
            }

            for(int idx = 0; idx < k; idx++){
                arr[idx] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void backTracking(int lottoIdx, int arrIdx){
        if(lottoIdx == 6){
            for(int num : lotto){
                sb.append(num + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = arrIdx; i < k; i++){
            lotto[lottoIdx] = arr[i];
            backTracking(lottoIdx + 1, i + 1);
        }
    }
}