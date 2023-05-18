package 백준.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
메모리 :136616KB
시간 : 1160ms
*/
public class 숫자카드_10815 {
    public static int[] arrA;
    public static int first = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        first = Integer.parseInt(br.readLine());

        arrA = new int[first];
        int arrNumber = 0;

        st = new StringTokenizer(br.readLine(), " ");


        StringBuilder sb = new StringBuilder();

        while (st.hasMoreElements()) {
            arrA[arrNumber++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        br.readLine();

        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());

            if (binarySearch(num)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        System.out.println(sb);

    }

    private static boolean binarySearch(int num) {

        int left = 0;
        int right = first - 1;

        while (left <= right) {
            int midindex = (left + right) / 2;
            int mid = arrA[midindex];

            if (num < mid) {
                right = mid - 1;
            } else if (num > mid) {
                left = mid + 1;
            } else if (mid == num) {
                return true;
            }
        }
        return false;
    }

}
