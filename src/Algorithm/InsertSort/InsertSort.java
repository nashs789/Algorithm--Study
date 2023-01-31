package Algorithm.InsertSort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 6, 9, 1, 3, 8, 2};
        int temp = 0;

        for(int i = 1; i < arr.length; i++){
            int idx = i;

            for(int j = i - 1; j >= 0; j--){
                if(arr[idx] < arr[j]){
                    temp = arr[idx];
                    arr[idx] = arr[j];
                    arr[j] = temp;
                    idx = j;
                }
            }

            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
