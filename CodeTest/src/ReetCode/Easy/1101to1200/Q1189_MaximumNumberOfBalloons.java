/**
* Author    : Lee In Bok 
* Date      : 2023.11.26(Sun)
* Spend Time: 07m 25s
* Runtime   : 13 ms (Beats 9.34%)
* Memory    : 42.1 MB (Beats 7.12%)
* Algoritm  : Hashing
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1189_MaximumNumberOfBalloons {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.maxNumberOfBalloons("loonbalxballpoon");

        System.out.println(result);
    }  
}

class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < text.length(); i++){
            char key = text.charAt(i);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        list.add(map.getOrDefault('b', 0));
        list.add(map.getOrDefault('a', 0));
        list.add(map.getOrDefault('l', 0) / 2);
        list.add(map.getOrDefault('o', 0) / 2);
        list.add(map.getOrDefault('n', 0));

        return list.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}