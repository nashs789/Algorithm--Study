/**
* Author    : Lee In Bok 
* Date      : 2023.11.08(Wed)
* Spend Time: 18m 40s
* Runtime   : 0 ms (Beats 100%)
* Memory    : 42.6 MB (Beats 87.50%)
* Algoritm  : Linked List
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         ListNode temp = head;
//         ListNode prev = null;

//         while(temp != null){
//             if(prev != null && prev.val == temp.val){
//                 prev.next = temp.next;
//             } else {
//                 prev = temp;
//             }

//             temp = temp.next;
//         }

//         return head;
//     }
// }