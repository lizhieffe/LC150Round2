package Accepted;

import Utils.ListNode;

public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            if (i % k == 0) {
                ListNode newLast = reverseBetweenNodes(last, cur.next);
                last.next = cur;
                last = newLast;
                cur = last;
            }
            cur = cur.next;
            i ++;
        }
        return dummy.next;
    }
    
    private ListNode reverseBetweenNodes(ListNode beg, ListNode end) {
        ListNode last = beg.next;
        ListNode cur = last.next;
        while (last.next != end) {
            ListNode tmp = beg.next;
            beg.next = cur;
            last.next = cur.next;
            cur = last.next;
            beg.next.next = tmp;
        }
        return last;
    }
}
