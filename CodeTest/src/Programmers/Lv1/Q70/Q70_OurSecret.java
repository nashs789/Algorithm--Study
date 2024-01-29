package Programmers.Lv1.Q70;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Q70_OurSecret {
    public static void main(String[] args) {
        String s = "zzzzz";
        String skip = "a";
        int index = 1;

        char[] arr = s.toCharArray();   // z = 122
        Map<Character, Integer> skipMap = Arrays.stream(skip.split("")).collect(Collectors.toMap(e -> e.charAt(0), e -> (int)e.charAt(0)));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            int cnt = 0;

            while(true){
                arr[i] += 1;
                cnt++;

                // z 일 경우
                if(arr[i] > 122){
                    arr[i] -= 26;
                }

                // skip 단어일 경우
                if(skipMap.containsKey(arr[i])){
                    cnt--;
                }

                // index 만큼 알파벳을 이동했을 경우
                if(cnt == index){
                    break;
                }
            }
        }

        for(char c : arr){
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}