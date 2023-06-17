import java.util.Scanner;

public class Q1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a1 = sc.nextInt(); 
        int a2 = sc.nextInt(); 
        int b1 = sc.nextInt(); 
        int b2 = sc.nextInt(); 

        int A= getLcm(a2, b2);
        int a = A / a2;
        int b = A / b2;
        int B = (a1*a)+(b1*b);

       
        int div = getGcd(B,A);
        if(B % div == 0 && A % div == 0) {
            sb.append(B / div + " ");
            sb.append(A / div);
        } else {
            sb.append(B +" ");
            sb.append(A);
        }
        System.out.println(sb);

    }
   
    public static int getGcd(int a, int b) { 
        if(b == 0) {
            return a;
        }
        return getGcd(b, a%b);
    }
  
    private static int getLcm(int a, int b) {
        return a * b / getGcd(a,b);
    }
}
