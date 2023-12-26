/**
* Author    : Lee In Bok 
* Date      : 2023.12.24(Sun)
* Spend Time: 35m 50s
* Runtime   : 208 ms
* Memory    : 17004 KB
* Algoritm  : Prime Number
 */

package BaekJoon.DivisorMultiplePrimeNumber.Q9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9020_GoldBach {

  public static final int MAX = 10001;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    boolean[] arr = getPrimeNumbers();

    for(int i = 0; i < T; i++){
      int num = Integer.parseInt(br.readLine());

      for(int j = num/2; j <= num; j++){
        if(arr[j]){
          continue;
        }

        int gap = num - j;

        if(!arr[gap]){
          sb.append(gap + " " + j + "\n");
          break;
        }
      }
    }
    System.out.println(sb.toString());
  }

  public static boolean[] getPrimeNumbers(){
    boolean[] arr = new boolean[MAX];

    for(int num = 2; num < MAX; num++){
      if(arr[num]){
        continue;
      }

      int next = num + num;
      while(next < MAX){
        arr[next] = true;
        next += num;
      }
    }

    return arr;
  }
}