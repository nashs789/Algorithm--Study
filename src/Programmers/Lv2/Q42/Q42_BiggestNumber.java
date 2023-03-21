package Programmers.Lv2.Q42;

import java.util.Arrays;
import java.util.Comparator;

public class Q42_BiggestNumber {
    public static void main(String[] args) {
        int[] numbers = {123,1232};
        String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
            }
        });

        for(String a : strNumbers){
            System.out.println(a);
            sb.append(a);
        }

        System.out.println(sb.toString().charAt(0) == '0' ? "0" : sb.toString());
    }
}

// 11:30 - 12:20 실패 ===> 런타임 에러 5개, 실패 2개   50분
// 11:00 - 11:30 실패 ===> 런타임 에러 6개, 실패 2개   30분
// 11:30 - 12:09 실패 ===> 실패 9                  39분
    // - 로직 변경
// 12:09 - 12:12 실패 ===> 실패 8                 3분
    // - 값이 0인경우 처리
// 12:12 - 12:20 성공                          8분