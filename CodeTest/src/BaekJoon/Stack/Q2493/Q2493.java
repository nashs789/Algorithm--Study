/**
* Author    : Lee In Bok 
* Date      : 2023.12.31(Sun)
* Problem   : 탑
* Spend Time: 15m 21s
* Runtime   : 732 ms
* Memory    : 105504 KB
* Algoritm  : Stack
 */

package BaekJoon.Stack.Q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q2493 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] tops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Stack<Top2> stack = new Stack<>();

    for(int i = 0; i < N; i++){
      Top2 t = new Top2(i, tops[i]);

      while(!stack.empty() && stack.peek().height <= t.height){
        stack.pop();
      }

      sb.append(stack.isEmpty() ? 0 : stack.peek().idx + 1).append(' ');
      stack.add(t);
    }

    System.out.println(sb);
  }
}

class Top2{
  int idx;
  int height;

  Top2(int idx, int height){
    this.idx = idx;
    this.height = height;
  }
}
