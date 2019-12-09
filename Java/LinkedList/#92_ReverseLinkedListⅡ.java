/**
 * 反转链表m-n的节点
 * 有两种情况: 1. 反转节点从头开始 2. 不从头开始
 * prev先跑到m的前一个节点, 保存节点为con, 接着执行n-m次反转操作
 * 
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode prev = null, curr = head;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;            
        }

        ListNode con = prev, tail = curr;
        ListNode tmp = null;

        while (n > 0) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            n--;
        }

        if (con == null) head = prev; // 从头开始
        else con.next = prev;
        tail.next = curr; 

        return head;
    }
}


