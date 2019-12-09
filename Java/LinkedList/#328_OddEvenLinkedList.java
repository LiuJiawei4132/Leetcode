/**
 * 将链表分成奇链表和偶链表,再把奇链表的最后一个节点与偶链表的头连起来
 */



public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
