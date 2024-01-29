// 메모리 	321540KB, 시간 	2900ms

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();

		int[] arr = new int[cnt];
		
		for (int i = 0; i<cnt; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i<cnt; i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.flush();
	}
}
