package BaekJoon.Greedy.Q16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16953_AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String from = st.nextToken();
        String to = st.nextToken();
        long answer = 1;

        while(true){
            if(from.equals(to)){
                break;
            }

            if(to.equals("")){
                answer = -1;
                break;
            }

            long temp = Long.parseLong(to);

            if(temp % 2 == 0){
                to = Long.toString(temp / 2);
                answer++;
                continue;
            }

            if(to.charAt(to.length() - 1) == '1'){
                to = to.substring(0, to.length() - 1);
                answer++;
                continue;
            }

            if((!to.equals("1") && temp % 2 != 0)){
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }
}
// 11:04 - 11:54