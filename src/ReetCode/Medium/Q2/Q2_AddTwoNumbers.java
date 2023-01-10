/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * [ Example 1 ]
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * [ Example 2 ]
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * [ Example 3 ]
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * [ Constraints ]
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

package ReetCode.Medium.Q2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Q2_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // 지우기
        ListNode l1FirstAddress;
        ListNode l2FirstAddress;

        ListNode l1 = new ListNode(2, new ListNode(4));
        l1FirstAddress = l1;
        l1 = l1.next;
        l1.next = new ListNode(3); 
                
        ListNode l2 = new ListNode(5, new ListNode(6));
        l2FirstAddress = l2;
        l2 = l2.next;
        l2.next = new ListNode(4);

        l1 = l1FirstAddress;
        l2 = l2FirstAddress;
        // 지우기

        BigDecimal sum = new BigDecimal(String.valueOf(getNumber(l1))).add(new BigDecimal(String.valueOf(getNumber(l2))));
        StringBuilder sb = new StringBuilder(sum.toString());
        ListNode answer = new ListNode();
        ListNode answerFirstAddress = answer;
        sb.reverse();

        for(int idx = 0; idx < sb.length(); idx++){
            answer.val = (sb.charAt(idx) - 48);
            if(idx != sb.length() - 1){
                answer.next = new ListNode();
            }
            answer = answer.next;
        }

        answer = answerFirstAddress;

        //return answer;
    }

    public static BigDecimal getNumber(ListNode listNode){
        StringBuilder sb = new StringBuilder();

        while(true){
            sb.append(listNode.val);

            if(listNode.next == null){
                break;
            }

            listNode = listNode.next;
        }

        return BigDecimal.valueOf(Long.parseLong(sb.reverse().toString()));
    }
}

// 21:28
// 1. 리스트에서 숫자 꺼내기
// 2. 꺼낸 숫자 역방향 정렬