/**
 * 根据x值的大小分隔链表
 * 我们可以创建两条,一条保存比目标值要小的值,一条保存比目标值要大的值
 * 再将两条链表合并起来(记得把大链表的末尾至空哦)
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        // 定义大小链表
        ListNode smaller = new ListNode(0), s = smaller;
        ListNode biger = new ListNode(0), b = biger;
        
        // 遍历主链表并根据目标值分割
        while (head != null) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }

        // 防止最后一个数小于目标值
        b.next = null;
        s.next = biger.next;
        return smaller.next;
    }
}