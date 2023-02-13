package Programmers.Lv2.Q4;

import java.util.ArrayList;
import java.util.List;

public class Q4_123Country {
    public static void main(String[] args) {
        int n = 48;
        List<Integer> list = new ArrayList<>();
        boolean flag = false;

        while(n >= 1){
            int rest = n % 3 == 0 ? 4 : n % 3;
            System.out.println("rest = " + rest);

            if(flag){
                list.add(rest == 4 ? 2 : rest == 2 ? 1 : 0);
            } else {
                list.add(rest);
            }

            if(rest == 4){
                flag = true;
            } else {
                flag = false;
            }

            if(list.size() > 2 && list.get(list.size() - 2) == 0){
                list.add(list.size() - 2 , 4);
                list.remove(list.size() - 2);
                list.add(list.size() - 1, list.get(list.size() - 1) == 4 ? 2 : list.get(list.size() - 1) == 2 ? 1 : 0);
                list.remove(list.size() - 1);
            }

            n /= 3;
        }

        StringBuilder sb = new StringBuilder();

        for(int idx = list.size() - 1; idx >= 0; idx--){
            sb.append(list.get(idx));
        }

        System.out.println(sb.toString().replace("0", ""));
    }
}