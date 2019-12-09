/**
 * 一眼就能看出这题要把链表链成环,剩下的就好解决啦!
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode p = head; // p用来找到最后一个节点
        int size = 1; // size用来表示链表的长度
        while (p.next != null) {
            p = p.next;
            size++;
        }

        if (k % size == 0) return head; // 如果循环次数与长度余等于0,则等于他本身

        p.next = head; // 头尾相连 喜结良缘

        k %= size; // 减少循环次数
        for (int i = 0; i < size - k; i++) {
            head = head.next;
            p = p.next;
        }
        p.next = null; // 最后记得把他们拆散!

        return head;
    }
}