// 43640 KB , 672 ms

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		String[] arr = new String[num];

		for (int i = 0; i < num; i++) {
			arr[i] = sc.next();
		}

		// 배열 -> Stream -> distinct (중복제거) -> 배열
        arr = Arrays.stream(arr).distinct().toArray(String[]::new);

		Arrays.sort(arr, (e1, e2) -> {
			if (e1.length() == e2.length()) {
				return e1.compareTo(e2);
			} else {
				return e1.length() - e2.length();
			}
		});

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			stringBuilder.append(arr[i]).append("\n");
		}
        
		System.out.println(stringBuilder.toString());
	}
}
