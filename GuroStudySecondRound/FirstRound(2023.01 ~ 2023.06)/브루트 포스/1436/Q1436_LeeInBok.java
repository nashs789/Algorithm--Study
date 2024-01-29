/**
 * - 666부터 1씩 증감시켜서 모든 수를 탐색하는 방법으로 진행
 * - 규칙이 있으나 코드로 구현하는게 힘들었음...
 * - 구현이 힘들었던 이유: 규칙의 존재는 하지만 정형화 시키지 못해 코드로 만들지 못함
 *
 * [ 메모리 ]      [ 시간 ]
 *  86876KB       292ms
 */

package BaekJoon.BruteForce.Q1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q1436_LeeInBok {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int cnt = Integer.parseInt(br.readLine());
        int curCnt = 0;
        int start = 666;

        while(true){
            if(cnt == curCnt){
                break;
            }

            if(Integer.toString(start).contains("666")){
                list.add(start);
                curCnt++;
            }

            start++;
        }

        System.out.println(list.get(cnt - 1));
    }
}