package BaekJoon.BinarySearch.Q2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110_SetUpRouter {

    public static int router;
    public static long answer;
    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int house = Integer.parseInt(st.nextToken());
        router = Integer.parseInt(st.nextToken());
        arr = new long[house];

        for(int idx = 0; idx < house; idx++){
            arr[idx] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[house - 1];

        while (left <= right){
            long mid = (left + right) / 2;

            if(chk(mid)){    // 설치가 된다 == 더 긴 거리를 시도할 수 있다
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean chk(long mid){
        int cnt = 1;    // 첫 집 공유기 설치
        long curHouse = arr[0];

        for(int idx = 1; idx < arr.length; idx++){
            long dist = arr[idx] - curHouse;

            if(dist >= mid){    // 두 집 사이의 거리가 기준 값보다 크거나 같은 경우 공유기 설치
                cnt++;
                curHouse = arr[idx];    // 공유기 설치된 집을 현재 집으로 설정
            }

            if(cnt == router){    // 공유기 설치 개수 == 설치해야할 공유기 개수
                answer = mid;
                return true;
            }
        }

        return false;
    }
}