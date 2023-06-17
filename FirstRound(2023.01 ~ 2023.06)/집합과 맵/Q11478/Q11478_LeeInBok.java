/**
 *  [ 효율성 ]
 *  - 메모리: 226856KB
 *  - 시간 : 700ms
 */

package BaekJoon.SetAndMap.Q11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q11478_CountOfDifference2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < len; i++){
            for(int j = i + 1; j <= len; j++){
                set.add(str.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}