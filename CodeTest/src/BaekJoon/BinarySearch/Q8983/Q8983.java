/**
* Author    : Lee In Bok 
* Date      : 2023.12.25(Mon)
* Spend Time: 52m 37s
* Runtime   : 58612 KB
* Memory    : 712 ms
* Algoritm  : Binary Search
 */

package BaekJoon.BinarySearch.Q8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8983 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int[] loc = Arrays.stream(br.readLine().split(" "))
                                           .mapToInt(Integer::parseInt)
                                           .sorted()
                                           .toArray();
    int cnt = 0; 

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int l = 0;
      int r = M - 1;

      while(l <= r){
        int mid = (l + r) / 2;
        int gap = loc[mid] - x;

        if(Math.abs(gap) + y <= L){
          cnt++;
          break;
        }

        if(gap > 0){
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }

    System.out.println(cnt);
  }
}