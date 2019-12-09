/**
 * 重排链表
 * 通过快慢指针将链表分成两半，将后一半进行反转
 * 反转后得到两个链表curr AND end
 * 在curr取一个 end取一个 你一个 我一个
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode end = reverse(slow.next);
        slow.next = null;

        ListNode curr = head;
        while (end != null) {
            ListNode tmp = end.next;
            end.next = curr.next;
            curr.next = end;
            end = tmp;
            curr = curr.next.next;
        }

    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, tmp = null;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}

