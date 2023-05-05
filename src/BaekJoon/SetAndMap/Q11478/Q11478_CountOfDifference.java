package BaekJoon.SetAndMap.Q11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q11478_CountOfDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");
        int len = str.length;
        Set<String> set = new HashSet<>();

        for(int k = 0; k < len; k++){
            for(int i = k; i < len; i++){
                for(int j = k; j < i + 1; j++){
                    sb.append(str[j]);
                }
                set.add(sb.toString());
                sb.setLength(0);
            }
        }

        System.out.println(set.size());
    }
}
