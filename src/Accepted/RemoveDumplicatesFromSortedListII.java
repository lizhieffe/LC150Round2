package Accepted;

import Utils.ListNode;

public class RemoveDumplicatesFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cNode = dummy;
        while (true) {
            if (cNode.next == null || cNode.next.next == null)
                break;
            if (cNode.next.val == cNode.next.next.val) {
                ListNode tmp = cNode.next;
                while (tmp != null && tmp.val == cNode.next.val)
                    tmp = tmp.next;
                cNode.next = tmp;
            }
            else
                cNode = cNode.next;
        }
        return dummy.next;
    }
}
