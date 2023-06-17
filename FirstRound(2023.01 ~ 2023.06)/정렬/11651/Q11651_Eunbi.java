import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = scanner.nextInt();
        int[][] arr = new int[input][2];
        for (int i=0; i<arr.length; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]) {
               return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}
