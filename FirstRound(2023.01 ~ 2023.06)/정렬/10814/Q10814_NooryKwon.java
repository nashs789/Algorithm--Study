// 메모리 154632KB , 메모리 1468ms

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[][] arr = new int[num][2];
		Map<Integer, String> names = new HashMap<Integer, String>();

		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = i;
			names.put(i, sc.next());
		}

		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < num; i++) {
			bw.write(arr[i][0] + " " + names.get(arr[i][1])+ "\n");
		}

		bw.flush();
	}
}
