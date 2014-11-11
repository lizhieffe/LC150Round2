package Accepted;

import Utils.ListNode;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode end = head;
        dummy.next = head;
        while (end.next != null) {
            if (end.next.val >= end.val)
                end = end.next;
            else {
                ListNode cNode = dummy;
                while (cNode.next.val < end.next.val)
                    cNode = cNode.next;
                ListNode tmp = end.next;
                end.next = tmp.next;
                tmp.next = cNode.next;
                cNode.next = tmp;
            }
        }
        return dummy.next;
    }
}
