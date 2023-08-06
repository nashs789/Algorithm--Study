/**
 *  [ 효율성 ]
 *  - 메모리: 31036KB
 *  - 시간 : 340ms
 */

package Baekjoon.Q3020;

import java.util.*;
import java.io.*;

/**
 * (첫 문제 풀이) -> 틀린 풀이
 * 1. 석순과 종유석 정보를 담을 int 배열 arr에 정보를 담습니다. (Arrays.fill())
 * 2. 누적합 배열을 사용해 arr의 정보를 누적해서 담습니다. (중첩 반복문)
 * 3. 정렬 후 최솟값을 찾고, 최솟값의 개수를 구합니다.
 *
 * 틀린 이유 : 시간 초과
 * -> n이 200000 미만, h가 500000 미만 이기 때문에 중첩반복문은 사용할 수 없음. (Arrays.fill() 또한 쓸 수 없음)
 * -> 정렬은 사용 가능하지만 옳은 방법이 아님
 * -> 2차원 배열의 경우, 메모리 초과가 날 것 같아 사용하지 않음
 *
 * (두 번째 풀이) -> 맞는 풀이
 * 1. 종유석 정보를 담을 int 배열 arr1과 석순 정보를 담을 int 배열 arr2에 정보를 담습니다. (index 활용)
 * 2. 예를 들어, index 4는 index 1,2,3의 정보를 같이 담아야 하므로 for문을 역순으로 진행해 누적합 알고리즘을 사용합니다.
 * 3. 다만, 홀수 번째를 뜻하는 석순의 정보는 비교할 때 역순으로 비교를 해야합니다. (천장에 달려있기 때문에)
 * 4. h번 동안 tmp에 종유석과 석순의 정보를 더한 값을 비교하며 최솟값을 갱신하고 개수를 세줍니다.
 */

public class bug {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[h + 1];
        int[] arr2 = new int[h + 1];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                arr1[num]++;
            } else {
                arr2[num]++;
            }
        }

        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

        for (int i = h - 1; i > 0; i--) {
            arr1[i] += arr1[i + 1];
            arr2[i] += arr2[i + 1];
        }
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

        for (int i = 1; i < h + 1; i++) { // 이렇게 사용할 경우, 정렬 없이 최솟값을 찾고 개수를 구할 수 있다.
            int tmp = arr1[i] + arr2[h - i + 1];
            if (tmp < min) {
                min = tmp;
                count = 1; // 최솟값 갱신
            } else if (tmp == min) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }
}

// 첫번째 풀이
//public class bug {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int h = Integer.parseInt(st.nextToken());
//        int idx = 0;
//        int min = 0;
//        int value;
//        int[] arr = new int[h + 1];
//        int[] sum = new int[h + 1];
//
//        for (int i = 1; i < n + 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            value = Integer.parseInt(st.nextToken());
//
//            if (i % 2 == 0) {
//                Arrays.fill(arr, 1, value + 1, 1);
//            } else {
//                Arrays.fill(arr, h - value + 1, h + 1, 1);
//            }
//
//            for (int j = 1; j < h + 1; j++) {
//                sum[j] += arr[j];
//            }
//            Arrays.fill(arr, 0);
//        }
//
//        Arrays.sort(sum);
//        min = sum[1];
//        for (int i = 1; i < h + 1; i++) {
//            if (min == sum[i]) {
//                idx++;
//            } else {
//                break;
//            }
//        }
//        System.out.println(min + " " + idx);
//    }
//}
