package Accepted;

import Utils.ListNode;

public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        boolean first = true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (true) {
            if (fast == null)
                return null;
            if (fast.next == fast)
                return fast;
            fast = fast.next;
            if (fast == head && first == true)
                first = false;
            else if (fast == head && first == false)
                return head;
            if (fast == null)
                return null;
            fast = fast.next;
            if (fast == head && first == true)
                first = false;
            else if (fast == head && first == false)
                return head;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        
        slow = dummy;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
