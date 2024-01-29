/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * [ Example 1 ]
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * [ Example 2 ]
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * [ Example 3 ]
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * [ Constraints ]
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */

package ReetCode.Easy.Q1;

public class Q1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] answer = new int[2];

        for(int idx1 = 0; idx1 < nums.length -1; idx1++){
            for(int idx2 = idx1 + 1; idx2 < nums.length; idx2++){
                if(nums[idx1] + nums[idx2] == target){
                    answer[0] = idx1;
                    answer[1] = idx2;
                }
            }
        }
    }
}