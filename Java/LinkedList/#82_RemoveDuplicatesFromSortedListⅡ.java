/**
 * 删除链表中重复的元素,因为表头有可能是重复的元素,所以我们需要一个哑节点
 * 这里我我们通过判断两个相邻节点的值是否相等
 * 
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;

            // 2.哑节点,快慢指针
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = head;

            while (fast != null)
            {
                // fast节点的值与下一个节点的值不同 或 fast节点的下一个节点为空
                if ((fast.next != null && fast.val != fast.next.val) || fast.next == null) 
                {                  
                    if (slow.next == fast)
                        slow = fast;
                    else                   
                        slow.next = fast.next; 
                }
                fast = fast.next; // fast.val == fast.next.val则快指针一直跑
            }

            return dummy.next;
    }
}