package BaekJoon.BinarySearch.Q1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1072_Game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int rate = (int)((long)Y * 100 / X);
        int game = 0;

        int left = 0;
        int right = 1000000000;

        while(left <= right){
            if(rate == 100 || rate == 99){
                break;
            }

            int mid = (left + right) / 2;
            int newX = X + mid;
            int newY = Y + mid;
            int newRate = (int)((long)newY * 100 / newX);

            if(newRate > rate){
                game = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(game == 0 ? -1 : game);
    }
}
