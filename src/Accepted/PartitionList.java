package Accepted;

import Utils.ListNode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mid = dummy;
        ListNode end = dummy;
        ListNode cNode = head;
        while (cNode != null) {
            if (cNode.val >= x) {
                cNode = cNode.next;
                end = end.next;
            }
            else if (mid.next == cNode) {
                mid = cNode;
                cNode = cNode.next;
                end = end.next;
            }
            else {
                ListNode tmp = mid.next;
                mid.next = cNode;
                end.next = cNode.next;
                cNode = cNode.next;
                mid.next.next = tmp;
                mid = mid.next;
            }
        }
        return dummy.next;
    }
    
}
