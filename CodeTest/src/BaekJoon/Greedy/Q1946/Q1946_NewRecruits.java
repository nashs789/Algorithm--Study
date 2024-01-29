package BaekJoon.Greedy.Q1946;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q1946_NewRecruits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCnt = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < testCnt; idx++){
            int recruitCnt = Integer.parseInt(br.readLine());
            int[][] score = new int[recruitCnt][2];
            int answer = 1; // 1등인 사람은 무조건 통과니까 1부터 시작

            for(int i = 0; i < recruitCnt; i++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for(int j = 0; j < input.length; j++){
                    score[i][j] = input[j];
                }
            }

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int stand = score[0][1];

            for(int i = 1; i < recruitCnt; i++){
                if(score[i][1] < stand){
                    stand = score[i][1];
                    answer++;
                }
            }

            bw.write(Integer.toString(answer) + "\n");
        }

        bw.flush();
        bw.close();
    }
}