/**
* Author    : Lee In Bok 
* Date      : 2023.11.11(Sat)
* Spend Time: 11m 41s
* Runtime   : 1 ms (Beats 35.76%)
* Memory    : 41 MB (Beats 73.26%)
* Algoritm  : Array
 */

import java.util.Arrays;

public class Q88_MergeSortedArray {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.merge(new int[]{1, 2, 3, 0, 0 ,0}, 3, new int[]{2, 5, 6}, 3);
    }    
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int idx = m; idx < nums1.length; idx++){
            nums1[idx] = nums2[idx - m];
        }

        Arrays.sort(nums1);
    }
}
