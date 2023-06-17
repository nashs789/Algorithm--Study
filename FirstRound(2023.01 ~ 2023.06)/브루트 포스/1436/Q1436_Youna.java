package studyBJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436_DirectorShun {

	/*
	 * 영화감독 숀 
	 * 
	 * 풀이	:	while문을 사용해서 계속 돌림.
	 * 			contains함수를 이용해서 666이 있으면 cnt ++ 	--> num=666 cnt = 1;
	 * 			n과 cnt가 같으면 break
	 * 
	 * 생각	:	성능이 너무 안좋다. 다른 방법을 찾아야 곘다. (이해는 가는데 코드로 못짜겠다.)
	 * 
	 * 제출	:	86052	300 ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 666;
		int cnt = 0;
		
		while(true) {
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			if(n == cnt) {
				break;
			}
			num++;
		}
		System.out.println(num);
	}

}
