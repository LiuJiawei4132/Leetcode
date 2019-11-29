/**
 * 新建一个链表，遍历两个链表，标志进位即可
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0), p = head;
        
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        // 判断循环结束时最后一位是否有进位
        if (carry == 1) {
            p.next = new ListNode(1);
        }

        return head.next;
    }
}
