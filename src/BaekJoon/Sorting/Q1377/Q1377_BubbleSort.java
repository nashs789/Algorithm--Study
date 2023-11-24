package BaekJoon.Sorting.Q1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Q1377_BubbleSort{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] arr = new Num[N];
        Num[] sorted = new Num[N];

        for(int i = 0; i < N; i++){
            Num num = new Num(Integer.parseInt(br.readLine()), i);
            arr[i] = num;
        }

        Arrays.sort(arr, new Comparator<Num>() {
            public int compare(Num n1, Num n2){
                return n1.num - n2.num;
            }
        });

        int max = 0;

        for(int i = 0; i < N; i++){
            if(max < arr[i].orgIdx - i){
                max = arr[i].orgIdx - i;
            }
        }

        System.out.println(max + 1);
    }
}

class Num{
  int num;
  int orgIdx;

  Num(int num, int orgIdx){
    this.num = num;
    this.orgIdx = orgIdx;
  }
}