package Accepted;

import Utils.ListNode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if (head == null)
        	return false;

        ListNode p1 = head;
        ListNode p2 = head;

        do {
        	p1 = p1.next;
        	p2 = p2.next;
        	if (p2 == null)
        		break;
        	else
        		p2 = p2.next;
        } while (p1 != p2 && p1 != null && p2 != null)
        if (p1 == null || p2 == null)
        	return false;
        return true;
    }
}
