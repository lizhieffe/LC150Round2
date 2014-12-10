package Accepted;

import Utils.ListNode;

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
        	return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
        	if (prev.val == curr.val)
        		curr = curr.next;
        	else {
        		prev.next = curr;
        		prev = curr;
        		curr = curr.next;
        	}
        }
        prev.next = null;
        return head;
    }
}
