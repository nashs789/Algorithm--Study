/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
//     public boolean ans = true;
    
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         order(p, q);

//         return ans;
//     }

//     public void order(TreeNode p, TreeNode q){
//         if(!ans) return;

//         if(p != null || q != null){
//             try {
//                 if(p.val != q.val){
//                     ans = false;
//                     return;
//                 }

//                 if(p.left != null || q.left != null) order(p.left, q.left);
//                 if(p.right != null || q.right != null) order(p.right, q.right);
//             } catch(Exception e){
//                 ans = false;
//             }
//         }
//     }
// }