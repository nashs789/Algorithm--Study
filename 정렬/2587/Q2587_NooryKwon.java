import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		int[] arr = new int[5];
		
		Scanner sc = new Scanner(System.in);
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		arr[4] = sc.nextInt();

		int mean = (arr[0] + arr[1] + arr[2] + arr[3] + arr[4]) / 5;
		Arrays.sort(arr);
	
		System.out.println(mean);
		System.out.println(arr[2]);
	}
}
