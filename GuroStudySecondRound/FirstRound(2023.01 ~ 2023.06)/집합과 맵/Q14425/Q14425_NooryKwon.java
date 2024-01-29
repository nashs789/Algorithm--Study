// 68076KB 1012ms

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int sNum = sc.nextInt();
		int words = sc.nextInt();

		Map<String, Integer> s = new HashMap<String, Integer>();

		int cnt = 0;

		for (int i = 0; i < sNum; i++) {
			String str = sc.next();
			s.put(str, i);
		}

		for (int i = 0; i < words; i++) {
			String str = sc.next();
			if (s.containsKey(str)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
