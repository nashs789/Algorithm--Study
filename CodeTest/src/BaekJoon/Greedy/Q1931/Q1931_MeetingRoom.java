/**
 * [ 문제 ]
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 * [ 입력 ]
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * 시작 시간과 끝나는 시간은 2(31승)-1보다 작거나 같은 자연수 또는 0이다.
 *
 * [ 출력 ]
 * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 * 11                               4
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 *
 * [ 힌트 ]
 * (1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.
 */

package BaekJoon.Greedy.Q1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1931_MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetings = Integer.parseInt(br.readLine());
        int[][] times = new int[meetings][2];
        int answer = 1;

        for(int idx1 = 0; idx1 < times.length; idx1++){
            int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int idx2 = 0; idx2 < times[idx1].length; idx2++){
                times[idx1][idx2] = time[idx2];
            }
        }

        // 배열 오름차순
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){     // 끝나는 시간 = 1번방 요소가 같을 경우 시작 시간으로 오름차순
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int preEnd = times[0][1];   // 첫 회의의 끝나는 시간

        for(int idx1 = 1; idx1 < times.length; idx1++){
            int curStr = times[idx1][0];    // 현 시간 회의의 시작 시간

            if(curStr < preEnd){    // 이전 회의 시간에 포함된 시간일 경우
                continue;
            }

            if(times[idx1][0] == times[idx1][1]){ // 시작과 끝이 같을 경우
                answer++;
                continue;
            }

            preEnd = times[idx1][1];
            answer++;
        }

        System.out.println(answer);
    }
}