package Programmers.Lv2.Q9;

public class Q9_NextBiggestNumber_sol2 {
    public static void main(String[] args) {
        int n = 78;
        String org = Integer.toBinaryString(n).replace("0", "");

        while(true){
            String next = Integer.toBinaryString(++n).replace("0", "");

            if(org.length() == next.length()){
                System.out.println(n);
                break;
            }
        }
    }
}