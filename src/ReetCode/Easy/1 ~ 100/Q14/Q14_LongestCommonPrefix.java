/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * [ Example 1 ]
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * [ Example 2 ]
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * [ Constraints ]
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

package ReetCode.Easy.Q14;

public class Q14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"reflower", "flow", "flight"};
        String prefix = "";

        // if(strs.length == 0) return prefix;
        // if(strs.length == 1) return strs[0];
        int min = strs[0].length();
        prefix = strs[0];


        for(int idx = 1; idx < strs.length; idx++){
            if(strs[idx].length() < min){
               prefix = strs[idx];
               min = prefix.length();
            }
        }

        for(int idx = 0; idx < strs.length; idx++){
            if(!strs[idx].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                idx = -1;
            }
        }
    }
}