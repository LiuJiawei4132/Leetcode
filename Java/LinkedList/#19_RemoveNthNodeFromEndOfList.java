/**
 * 1.先遍历链表的获取长度，再用总长度减去n就能获取倒数第n个节点的位置(要遍历两次)
 * 
 * 
 * 2.删除链表中倒数第n个节点，用一个哑节点（删除第一个元素）和双指针p q
 * 先移动p n+1(因为有哑节点要算进去)个节点，当p到达位置后，p和q一起移动直到p==null
 * 此时q的下一个节点就是倒数第n个节点
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode pos = head;
        int size = 0;
        while (pos != null) {
            pos = pos.next;
            size++;
        }
        
        size -= n;
        if (size == 0) {
            head = head.next;
            return head;  
        } 
        
        pos = head;
        for (int i = 1; i < size; i++) {
            pos = pos.next;
        }
        
        pos.next = pos.next.next;
        
        return head;
    }
}