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