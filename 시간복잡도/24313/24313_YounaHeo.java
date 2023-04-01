package studyBJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ24313_Algorithm_7 {

	/*
	 * 풀이1	:	수학으로 풀이 후  + 변수를 만들어 하나씩 대입했다.
	 * 			1. 거짓인 조건 판단:	14268	128ms 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		int c  = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int fn = (a1 * n) + a0;
		
		
		//	a0 <= n * (c-a1) 	-->c-a1 가 음수면 부등호가 바뀐다.
		//	c - a1 < 0	일때 조건.
//		int answer = 1;
//		if(fn > c * n || c < a1) {	// && || 주의! 예)!(a && b) --> !a || !b
//			
//			answer = 0;
//		}
		
//		2. 참인 조건	:	14176	120ms  --> 거짓 조건보다 조금 더 빠르다.
		int answer = 0;
		if(fn <= c * n && c >= a1) {
			answer = 1;
		}
		System.out.println(answer);
	}
}
