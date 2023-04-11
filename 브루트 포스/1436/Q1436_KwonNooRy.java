import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();

        long title = 665;
		
	for (int i=0; i<N; i++) {
	    do {
		title++;
	    } while (!Long.toString(title).contains("666"));
	}
	System.out.println(title);
    }
}
