package BaekJoon.String.Q10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10809_SearchAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] loc = new int[26];
        String in = br.readLine();

        for(int idx = 0; idx < 26; idx++){
            loc[idx] = -1;
        }

        for(int idx = 0; idx < in.length(); idx++){
            int letter = in.charAt(idx) - 97;

            if(loc[letter] == -1){
                loc[letter] = idx;
            }
        }

        for(int i : loc){
            System.out.print(i + " ");
        }
    }
}

//10:22
// IOException 은 java.io 에 있다
// 세미콜론(;) 빼먹지 말자
// String 의 length 는 메소드다
