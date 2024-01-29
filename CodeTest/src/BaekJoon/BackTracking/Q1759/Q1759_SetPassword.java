package BaekJoon.BackTracking.Q1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1759_SetPassword {

    public static int L;
    public static int C;
    public static char[] comb;
    public static char[] alphabet;
    public static StringBuilder sb = new StringBuilder();
    public static Set<Character> vowel = new HashSet(Arrays.asList((new Character[]{'a', 'e', 'i', 'o', 'u'})));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        comb = new char[L];
        alphabet = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(alphabet);

        backTracking(0, 0);
        System.out.println(sb);
    }

    public static void backTracking(int idx, int len){
        if(len == L){
            if(!isValidPw()){
                return;
            }

            for(char c : comb){
                sb.append(c);
            }
            sb.append('\n');
            return;
        }

        for(int i = idx; i < C; i++){
            comb[len] = alphabet[i];
            backTracking(i + 1, len + 1);
        }
    }
    public static boolean isValidPw(){
        int volCnt = 0;
        int conCnt = 0;

        for(char c : comb){
            if(vowel.contains(c)){
                volCnt++;
            } else {
                conCnt++;
            }
        }

        return volCnt > 0 && conCnt > 1 ? true : false;
    }
}