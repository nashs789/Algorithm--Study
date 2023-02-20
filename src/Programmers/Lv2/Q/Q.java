package Programmers.Lv2.Q;

import java.util.*;

public class Q {
    public static void main(String[] args) {
        String[] phone_book = {"12", "123", "1235", "567", "88"};
        // String[] phone_book = {"123", "123", "456"};
        // String[] phone_book = {"119", "97674223", "1195524421", "0"};
        // String[] phone_book = {"0"};
        boolean flag = true;

        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int maxLen = phone_book[0].length();
        Map<Integer, LinkedList<String>> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++){
            int len = phone_book[i].length();

            if(map.get(len) == null){
                map.put(len, new LinkedList<>());
            }

            map.get(len).add(phone_book[i]);

            for(int j = len + 1; j <= maxLen; j++){
                LinkedList<String> list = map.get(j);
                if(list == null){
                    continue;
                }

                for(String str : list){
                    if(str.startsWith(phone_book[i])){
                        flag = false;
                        break;
                    }
                }
            }

            if(!flag){
                break;
            }
        }

        System.out.println(flag);
    }
}

// 21:20 - 22:32 ===> 14 / 24 (런타임 에러: 10개)
// 22:32 - 22:34 ===> 21 / 24 (실패: 시간 초과 3개)
// 22:34 - 22:59 ===> 21 / 24 (실패: 시간 초과 3개)