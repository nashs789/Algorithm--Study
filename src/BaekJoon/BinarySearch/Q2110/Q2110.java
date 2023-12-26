/**
* Author    : Lee In Bok 
* Date      : 2023.12.26(Tue)
* Spend Time: 16m 24s
* Runtime   : 340 ms
* Memory    : 29908 KB
* Algoritm  : Binary Search
 */

package BaekJoon.BinarySearch.Q2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
  public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());

     int N = Integer.parseInt(st.nextToken());
     int C = Integer.parseInt(st.nextToken());
     int[] houses = new int[N];
     
     for(int i = 0; i < N; i++){
       houses[i] = Integer.parseInt(br.readLine());
     }

     Arrays.sort(houses);
     int min = Integer.MAX_VALUE;
     int l = 1;
     int r = houses[N - 1];

     while(l <= r){
      int mid = (l + r) / 2;
      int cnt = 1;
      int cur_loc = 0;

      for(int i = 0; i < N; i++){
        if(houses[i] - houses[cur_loc] >= mid){
           cur_loc = i;
           cnt += 1;
        }
      }

      if(cnt >= C){
        l = mid + 1;
        min = mid;
      } else {
        r = mid - 1;
      }
    }

    System.out.println(min); 
  }
}