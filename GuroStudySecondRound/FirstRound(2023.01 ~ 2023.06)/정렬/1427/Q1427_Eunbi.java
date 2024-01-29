import java.io.*;
import java.util.*;

/**
 * 	메모리 : 14420KB
 * 	시간 : 128ms
 */
public class Q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String result = "";

        String[] arr = input.split("");
        Arrays.sort(arr, Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
