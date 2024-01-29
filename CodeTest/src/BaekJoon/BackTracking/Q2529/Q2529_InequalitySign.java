package BaekJoon.BackTracking.Q2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2529_InequalitySign {

    public static int k;
    public static long max = Long.MIN_VALUE;
    public static long min = Long.MAX_VALUE;
    public static String maxStr;
    public static String minStr;
    public static int[] seq;
    public static String[] eqSigns;
    public static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        seq = new int[k + 1];
        eqSigns = br.readLine().split(" ");

        backTracking(0);
        System.out.println(maxStr);
        System.out.print(minStr);
    }

    public static void backTracking(int seqIdx){
        if(seqIdx == k + 1){
            String s = Arrays.toString(seq).replaceAll("[^0-9]", "");
            long n = Long.parseLong(s);

            if(max < n){
                max = n;
                maxStr = s;
            }

            if(min > n){
                min = n;
                minStr = s;
            }

            return;
        }

        for(int idx = 0; idx < 10; idx++){
            if(!visited[idx]){
                seq[seqIdx] = idx;
                
                if(seqIdx != 0 && !isOk(seqIdx)){
                    continue;
                }

                visited[idx] = true;
                backTracking(seqIdx + 1);
                visited[idx] = false;
            }
        }
    }

    public static boolean isOk(int idx){
        String eqSign = eqSigns[idx - 1];
        int num1 = seq[idx - 1];
        int num2 = seq[idx];

        if(eqSign.equals(">") && num1 > num2){
            return true;
        } else if(eqSign.equals("<") && num1 < num2){
            return true;
        }

        return false;
    }
}