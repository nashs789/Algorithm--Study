package Algorithm.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 6, 9, 1, 3, 8, 2};
        int temp = 0;
        int idx = 0;

        for(int i = 0; i < arr.length - 1; i++){
            int min = 10;
            
            for(int j = i; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    idx = j;
                }
            }

            temp = arr[i];
            arr[i] = min;
            arr[idx] = temp;
            
            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
