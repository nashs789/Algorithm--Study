// 378036 KB, 3848 ms

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		long[] rowArr = new long[num];

		for (int i = 0; i < num; i++) {
			rowArr[i] = sc.nextLong();
		}

		// 배열 -> Stream -> distinct (중복제거) -> 배열
		long[] arr = Arrays.stream(rowArr).distinct().toArray();

		Arrays.sort(arr);

		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		for (int i=0; i<arr.length; i++) {
			map.put(arr[i], i);
		}
		
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < rowArr.length; i++) {
			stringBuilder.append(map.get(rowArr[i]) +" ");
		}

		System.out.println(stringBuilder.toString());
	}
}
