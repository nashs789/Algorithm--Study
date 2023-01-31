package Algorithm.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 6, 9, 1, 3, 8, 2};
        int temp = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
