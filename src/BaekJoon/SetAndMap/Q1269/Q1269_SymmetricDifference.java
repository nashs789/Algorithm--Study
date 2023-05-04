package BaekJoon.SetAndMap.Q1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1269_SymmetricDifference {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int cntA = Integer.parseInt(st.nextToken());
        int cntB = Integer.parseInt(st.nextToken());
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        int cnt = 0;

        initSet(setA);
        initSet(setB);

        for(String num : setA){
            if(setB.contains(num)){
                cnt++;
            }
        }

        System.out.println(setA.size() + setB.size() - (cnt * 2));
    }

    public static void initSet(Set<String> set) throws IOException {
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            set.add(st.nextToken());
        }
    }
}
