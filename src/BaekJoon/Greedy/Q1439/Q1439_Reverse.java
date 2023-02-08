package BaekJoon.Greedy.Q1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1439_Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("");
        boolean isZero = S[0].equals("0") ? true : false;
        int zero = isZero ? 1 : 0;
        int one = isZero ? 0 : 1;

        for(int idx = 1; idx < S.length; idx++){
            if(isZero && S[idx].equals("1")){
                one++;
                isZero = false;
            } else if(!isZero && S[idx].equals("0")){
                zero++;
                isZero = true;
            }
        }

        System.out.println(zero > one ? one : zero);
    }
}

// 11:04