/**
* Author    : Lee In Bok 
* Date      : 2023.11.01(Wed)
* Spend Time: 04m 40s
* Runtime   : 0 ms (Beats 100%)
* Memory    : 43.43 MB (Beats 22.47%)
* Algoritm  : Array
 */

package Q35;

public class Q35_SearchInsertPosition {
    public static void main(String[] args){
        int result = searchInsert(new int[]{1, 3, 5, 6}, 5);

        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target || nums[i] > target){
                return i;
            }
        }

        return nums.length;
    }
}