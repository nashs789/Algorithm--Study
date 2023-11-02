/**
* Author    : Lee In Bok 
* Date      : 2023.11.03(Fri)
* Spend Time: 25m 09s
* Runtime   : 292 ms
* Memory    : 26248 KB
* Algoritm  : Prefix Sum
 */

package BaekJoon.SlidingWindow.Q2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2559_Sequence {

    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for(int idx = 1; idx < prefix.length; idx++){
            prefix[idx] = prefix[idx - 1] + arr[idx];
        }

        System.out.println(getAns(prefix));
    }

    public static int getAns(int[] prefix){
        int ans = prefix[K - 1];

        for(int idx = K; idx < prefix.length; idx++){
            ans = Math.max(ans, prefix[idx] - prefix[idx - K]);
        }

        return ans;
    }
}