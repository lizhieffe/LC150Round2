package Accepted;

import Utils.ListNode;

public class SortList {

	public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        while (end.next != null)
            end = end.next;
        sortList(dummy, end);
        return dummy.next;
    }
    
    private void sortList(ListNode beg, ListNode end) {
        if (beg == end || beg.next == end || beg.next == null)
            return;
        ListNode mid = beg.next;
        ListNode midPrev = beg;
        ListNode newEnd = mid;
        ListNode pNode = beg;
        ListNode cNode = beg.next;
        while (true) {
            boolean toBreak = false;
            if (cNode == end)
                toBreak = true;
            if (cNode.val < mid.val) {
                ListNode tmp = midPrev.next;
                midPrev.next = cNode;
                pNode.next = cNode.next;
                midPrev.next.next = mid;
                midPrev = midPrev.next;
                cNode = pNode.next;
            }
            else {
                newEnd = cNode;
                cNode = cNode.next;
                pNode = pNode.next;
            }
            if (toBreak)
                break;
        }
        sortList(beg, midPrev);
        sortList(mid, newEnd);
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(4);
    	head.next.next = new ListNode(1);
    	new SortList().sortList(head);
    }
}
