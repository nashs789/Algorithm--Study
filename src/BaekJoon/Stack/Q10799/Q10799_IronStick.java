package BaekJoon.Stack.Q10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q10799_IronStick {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Parenthesis> stack = new Stack<>();
        List<Razer> razers = new ArrayList<>();
        List<Stick> sticks = new ArrayList<>();

        for(int idx = 0; idx < str.length(); idx++){
            char letter = str.charAt(idx);

            if(letter == ')' && (!stack.isEmpty() && stack.peek().letter == '(')){
               // 레이저가 되는 기준은 서로 붙어있는 괄호 == 인덱스 차이가 1인 케이스
               if(idx - stack.peek().index == 1){
                   razers.add(new Razer(idx - 1, idx));
               } else {
                   sticks.add(new Stick(stack.peek().index, idx));
               }

               stack.pop();
               continue;
            }

            stack.push(new Parenthesis(letter, idx));
        }

        for(int i = 0; i < razers.size(); i++){
            Razer r = razers.get(i);

            for(int j = 0; j < sticks.size(); j++){
                Stick s = sticks.get(j);

                if(s.left < r.left && s.right > r.right){
                    s.addPiece();
                }
            }
        }

        int sum = 0;

        for(Stick s : sticks){
            sum += s.piece;
        }

        System.out.println(sum);
    }
}

class Parenthesis{
    char letter;
    int index;

    public Parenthesis(char letter, int index) {
        this.letter = letter;
        this.index = index;
    }
}

class Razer {
    int left;
    int right;

    public Razer(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

class Stick {
    int left;
    int right;
    int piece;    // 막대가 몇 조각인지

    public Stick(int left, int right) {
        this.left = left;
        this.right = right;
        this.piece = 1;
    }

    public void addPiece(){
        this.piece += 1;
    }
}