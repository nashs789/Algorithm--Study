import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
*	  메모리 : 23212KB
*   시간 : 636ms
*
*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int startNum = sc.nextInt();
        int endNum = sc.nextInt();

        for (int i=startNum; i<=endNum; i++) {
            if(isPrime(i)) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static boolean isPrime(int num) {
        if(num == 1) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
