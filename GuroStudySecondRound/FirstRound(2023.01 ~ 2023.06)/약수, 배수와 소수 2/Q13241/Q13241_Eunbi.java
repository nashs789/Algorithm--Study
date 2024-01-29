import java.util.Scanner;

/*
* 메모리 :  17728 KB
* 시간 : 208 ms
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long result = getLcm(a,b);
        System.out.println(result);
    }
    public static long getGcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return getGcd(b,a%b);

    }
    public static long getLcm(long a, long b) {
        return a*b /getGcd(a,b);
    }
}
