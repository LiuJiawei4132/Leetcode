/**
 * 快慢指针，快指针到末尾的时候，慢指针刚好到一半
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode slow = head, fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
