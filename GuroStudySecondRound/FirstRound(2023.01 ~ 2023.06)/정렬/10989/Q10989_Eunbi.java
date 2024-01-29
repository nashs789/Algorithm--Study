import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int[] inputArr = new int[input];

        for(int i=0;i<inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputArr);

        for(int i=0; i<inputArr.length; i++) {
            bw.write(inputArr[i] + "\n");
        }
        br.close();
        bw.close();

    }

}
