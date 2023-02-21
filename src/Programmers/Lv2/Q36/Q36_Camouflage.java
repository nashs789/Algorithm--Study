package Programmers.Lv2.Q36;

import java.util.HashMap;
import java.util.Map;

public class Q36_Camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int idx = 0; idx < clothes.length; idx++){
            map.put(clothes[idx][1], map.getOrDefault(clothes[idx][1], 1) + 1);
        }

        for(String key : map.keySet()){
            answer *= map.get(key);
        }

        System.out.println(answer - 1);
    }
}

// 1시간 10분 -> 생각
// 10:55
