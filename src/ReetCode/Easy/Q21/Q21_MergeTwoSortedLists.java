/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * [ Example 1 ]
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * [ Example 2 ]
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * [ Example 3 ]
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * [ Constraints ]
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
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

package ReetCode.Easy.Q21;

public class Q21_MergeTwoSortedLists {
    public static void main(String[] args) {
        // ======================= 문제에서 제공해주는 변수 =======================
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list1FirstNode = list1; // 첫 노드 주소
        list1 = list1.next;
        list1.next = new ListNode(4);
        list1 = list1FirstNode;

        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode list2FirstNode = list2; // 첫 노드 주소
        list2 = list2.next;
        list2.next = new ListNode(4);
        list2 = list2FirstNode;
        // ====================================================================

        // if(list1 == null && list2 == null) return new ListNode().next;
        ListNode mergedList = new ListNode();
        ListNode mergedListFirstNode = mergedList;

        while(true){
            if(list1 == null && list2 != null){
                changeNode(mergedList, list2);
                mergedList = mergedList.next;
                list2 = list2.next;
                continue;
            }

            if(list2 == null && list1 != null){
                changeNode(mergedList, list1);
                mergedList = mergedList.next;
                list1 = list1.next;
                continue;
            }

            if(list1 == null && list2 == null){
                break;
            }

            if(list1.val <= list2.val){
                mergedList.val = list1.val;
                mergedList.next = new ListNode();
                mergedList = mergedList.next;
                list1 = list1.next;
            } else {
                mergedList.val = list2.val;
                mergedList.next = new ListNode();
                mergedList = mergedList.next;
                list2 = list2.next;
            }
        }

        // return mergedListFirstNode;
    }

    public static void changeNode(ListNode to, ListNode from){
        to.val = from.val;
        if(!(from.next == null)){
            to.next = new ListNode();
        }
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}