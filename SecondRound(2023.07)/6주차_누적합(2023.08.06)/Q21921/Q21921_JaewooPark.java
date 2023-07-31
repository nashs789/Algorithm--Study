/**
 *  [ 효율성 ]
 *  - 메모리: 52688KB
 *  - 시간 : 676ms
 */


package Baekjoon.Q21921;

import java.util.*;
import java.io.*;

/* 
 * 1. 누적합 배열을 선언합니다.
 * 2. 누적합 배열을 사용해 key값을 도출합니다. (x 연속된 날들의 방문자 수)
 * 3. HashMap<Integer, Integer>에 key 값이 없을 경우 1, 있을 경우 value에 +1을 해줍니다.
 * 4. map.keySet()을 리스트에 담고 오름차순 정렬을 해줍니다.
 * 5. 정렬된 상태에서 마지막 값이 0이면 "SAD"를, 아닐 경우 key값과 value값을 출력해줍니다.
*/

public class blog {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list;

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = x; i < n + 1; i++) {
            int key = (sum[i] - sum[i - x]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int answer = list.get(map.size() - 1);
        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(map.get(answer));
        }

    }
}

