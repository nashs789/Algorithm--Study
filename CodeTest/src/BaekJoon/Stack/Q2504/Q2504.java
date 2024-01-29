/**
* Author    : Lee In Bok 
* Date      : 2023.12.29(Fri)
* Spend Time: 47m 48s
* Runtime   : 124 ms
* Memory    : 14280 KB
* Algoritm  : Stack
 */

package BaekJoon.Stack.Q2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine().replace("()", "2").replace("[]", "3");;
    Stack<Character> stack = new Stack<>();

    int mul = 1;
    int ans = 0;

    for(int i = 0; i < s.length(); i++){
      char ch = s.charAt(i);

      if(ch == '('){
        mul *= 2;
      } else if(ch == ')'){
        mul /= 2;
      } else if(ch == '['){
        mul *= 3;
      } else if(ch == ']'){
        mul /= 3;
      }

      if(!stack.isEmpty()){
        if(ch == ')' && stack.peek() == '('){
          stack.pop();
          continue;
        } else if(ch == ']' && stack.peek() == '['){
          stack.pop();
          continue;
        }
      }

      if(48 <= ch && ch <= 57){
        ans += mul * Character.getNumericValue(ch);
      } else {
        stack.add(ch);
      }
    }

    System.out.println(stack.isEmpty() ? ans : 0);
  }
}