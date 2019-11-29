/**
 * 利用快慢指针的特性，当快指针抵达末尾时，慢指针刚好到链表长度的一半
 * 通过慢指针将链表的前一半反转，再判断两个链表的节点是否相同

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, right;
        ListNode prev = null, left = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            left = slow;
            slow = slow.next;
            left.next = prev;
            prev = left;
        }

        // 链表奇偶数判断
        right = fast != null ? slow.next : slow;
        
        while (right != null) {
            if (right.val != left.val) return false;
            right = right.next;
            left = left.next;
        }

        return true;
    }
}
