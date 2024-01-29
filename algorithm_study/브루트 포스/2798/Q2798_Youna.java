package studyBJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2798_Blackjack {

	/*
	 * 블랙잭 
	 *  
	 *  풀이	:	숫자 3개 조합을 구하기.
	 *  		for문을 3번 돌려 조합을 만들고 같으면 바로 출력,
	 *  		다르면 sum에 배열의 합을 넣고 비교, sum보다 크고 m보다 작을경우 sum = temp
	 *  		
	 *  결과 :	14112	128ms
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] arr = new int [n];
		int sum = 0;
		int temp = 0;	// 비교할 변수 
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n-2; i++) {				// 끝 2개를 남기고 비교. 
			for(int j = i+1; j < n-1; j++) {		// 끝 1개를 남기고 비교. 
				for(int k = j+1; k < n; k++) {		
					temp = arr[i] + arr[j] + arr[k];	// 5, 6, 7 -> 18 != 21
					if(temp == m) {
						bw.write(String.valueOf(temp));
						bw.flush();
						bw.close();
						return;
					}
					if(temp > sum && temp < m) {	// sum = 18;  5, 6, 8 / 5, 6, 9  // 5, 7, 8 / 5, 7, 9 / 5, 8, 9 
						sum = temp;
					}
				}
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		
	}

}
