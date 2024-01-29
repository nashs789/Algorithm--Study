// 메모리 17676KB, 시간 204ms

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String num = sc.next();

		Integer[] arr = new Integer[num.length()];
		
		for (int i = 0; i<num.length(); i++) {
			arr[i] = Integer.parseInt(num.substring(i, i+1));
		}
		
		Arrays.sort(arr, Comparator.reverseOrder());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i<num.length(); i++) {
			bw.write(arr[i]+"");
		}
		
		bw.flush();
	}
}
