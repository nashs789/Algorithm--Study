package studyBJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19532_MathIs {

	/*
	 * 수학은 비대면 강의입니다 
	 * 
	 * 출력	:	문제의 답인 $x$와 $y$를 공백으로 구분해 출력한다.
	 * 
	 * 풀이	:	수학 연립방적식을 사용. x, y를 구한 후 입력값을 대입했다.
	 * 
	 * 정답	:	1. 그냥 sysout 했을때	16032	148 ms
	 * 			2. StringBuilder	14144	124 ms
	 * 
	 * 깨달은점 : 단순 연산시에도 문자열 합칠때엔 StringBuilder가 성능이 좋다. 
	 */
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
//		int c = Integer.parseInt(st.nextToken());
//		int d = Integer.parseInt(st.nextToken());
//		int e = Integer.parseInt(st.nextToken());
//		int f = Integer.parseInt(st.nextToken());
//		
//		int x = ((c*e)-(b*f))/((a*e)-(d*b));
//		int y = ((c*d)-(a*f))/((b*d)-(a*e));
//		
//		System.out.println(x+ " " + y);
//		
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder	sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int x = ((c*e)-(b*f))/((a*e)-(d*b));
		int y = ((c*d)-(a*f))/((b*d)-(a*e));
		
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
		
		
	}

}
