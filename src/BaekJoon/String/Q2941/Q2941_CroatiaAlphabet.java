package BaekJoon.String.Q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941_CroatiaAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] croatia_alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int idx = 0; idx < croatia_alpha.length; idx++){
            str = str.replace(croatia_alpha[idx], "0");
        }

        str = str.replaceAll("[A-Za-z]", "0");

        System.out.println(str.length());
    }
}