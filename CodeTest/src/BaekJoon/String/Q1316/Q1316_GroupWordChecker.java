package BaekJoon.String.Q1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q1316_GroupWordChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < cnt; i++){
            String str = br.readLine();
            Set<Character> set = new HashSet<>();
            boolean isGroup = true;

            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);

                if(set.contains(ch)){
                    isGroup = false;
                    break;
                }

                if(j + 1 != str.length() && ch != str.charAt(j + 1)){
                    set.add(ch);
                }
            }

            if(isGroup){
                answer++;
            }
        }
        System.out.println(answer);
    }
}