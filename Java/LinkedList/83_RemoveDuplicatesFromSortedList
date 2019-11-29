/**
 * 去除链表中重复成分，只需要改变下一个节点
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) p.next = p.next.next;
            else p = p.next;
        }

        return head;
    }
}
