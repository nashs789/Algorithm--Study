/**
* Author    : Lee In Bok 
* Date      : 2023.12.01(Fri)
* Spend Time: 04m 26s
* Runtime   : 0 ms (Beats 100%)
* Memory    : 41.9 MB (Beats 23.92%)
* Algoritm  : Tree
 */

// class Solution {
//     int max = 0;

//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
        
//         order(1, root);

//         return max;
//     }

//     public void order(int depth, TreeNode root){
//         max = Math.max(depth, max);

//         if(root != null){
//             if(root.left != null){
//                 order(depth + 1, root.left);
//             }

//             if(root.right != null){
//                 order(depth + 1, root.right);
//             }
//         }
//     }
// }