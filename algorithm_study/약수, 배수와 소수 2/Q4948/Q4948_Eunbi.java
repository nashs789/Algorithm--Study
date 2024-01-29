import java.util.Scanner;

public class Q4948 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            int n = in.nextInt();
            if(n==0) break;
            int count = 0;

            for(int i=n+1; i<=n*2; i++) {
                if(isPrime(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    static boolean isPrime(int Number) {
        if(Number == 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(Number); i++) {
            if(Number % i == 0) {
              return false;
            }
        }
        return true;
    }
}
