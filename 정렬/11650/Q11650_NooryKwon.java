// 185228 KB, 1548 ms

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[][] arr = new int[num][2];

		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < num; i++) {
			stringBuilder.append(arr[i][0]+" "+arr[i][1]).append("\n");
		}

		System.out.println(stringBuilder.toString());
	}
}
  
