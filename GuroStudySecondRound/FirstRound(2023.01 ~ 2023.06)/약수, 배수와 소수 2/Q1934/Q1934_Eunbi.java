import java.io.IOException;
import java.util.Scanner;

/**
메모리 : 22328KB
시간 : 312ms
**/
public class Q1934 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for(int i=0; i<num; i++) {
            int lcm = getLcm(sc.nextInt(),sc.nextInt());
            sb.append(lcm + "\n");
        }
        System.out.println(sb);

    }
    // 최대 공배수
    public static int getGcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGcd(b,a%b);

    }
    //최소 공배수
    public static int getLcm(int a, int b) {
        return a*b/getGcd(a,b);
    }
}
