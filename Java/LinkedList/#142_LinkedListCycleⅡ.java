/**
 * 方法1:
 * 双指针跑跑跑，跑到他们相遇的节点target
 * 找到target之后，头节点和target一起跑，他们相遇的地方就是重叠的地方啦
 * 
 * 方法2:
 * 哈希表无敌！
 */

public class Solution {
    public ListNode findTarget(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode target = findTarget(head);
        if (target == null) return null;
        
        ListNode site1 = head, site2 = target;

        while (site1 != site2) {
            site1 = site1.next;
            site2 = site2.next;
        }
        return site1;
    }
}