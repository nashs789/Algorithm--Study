/**
 * [ 문제 설명 ]
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * [ 제한사항 ]
 * 1 ≤ babbling의 길이 ≤ 100
 * 1 ≤ babbling[i]의 길이 ≤ 30
 * 문자열은 알파벳 소문자로만 이루어져 있습니다.
 *
 * [ 입출력 예 ]
 * babbling	                                            result
 * ["aya", "yee", "u", "maa"]	                          1
 * ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	      2
 *
 * [ 입출력 예 #1 ]
 *
 * ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
 *
 * [ 입출력 예 #2 ]
 *
 * ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은
 * "aya" + "ye" = "ayaye",
 * "ye" + "ma" + "woo" = "yemawoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.
 *
 * [ 유의사항 ]
 * 네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다.
 * 예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
 */

package Lv1.Q9;

import java.util.ArrayList;
import java.util.List;

public class Q9_Babbling {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "maobjwoo", "yemawoo", "ayaayaa", "ayaaya", "ayaayayayeyeyewoowoowoomama"};
        String[] can = {"aya", "ye", "woo", "ma"};
        List<Integer> removeList = new ArrayList<>();
        int answer = 0;

        for(int idx = 0; idx < babbling.length; idx++){
            if(isSequential(babbling[idx], can)){
                continue;
            }

            for(int idx2 = 0; idx2 < can.length; idx2++){
                if(babbling[idx].indexOf(can[idx2]) != -1){
                    removeList.add(idx2);
                }
            }

            for(Integer idx3 : removeList){
                babbling[idx] = babbling[idx].replaceAll(can[idx3], " ");
            }
            removeList.clear();

            if(babbling[idx].replaceAll("\\s", "").equals("")){
                answer++;
            }
        }

        System.out.println("answer = " + answer);
    }

    private static boolean isSequential(String babbling, String[] can) {
        for(int idx = 0; idx < can.length; idx++){
            if(babbling.indexOf(can[idx] + can[idx]) != -1){
                return true;
            }
        }

        return false;
    }
}
