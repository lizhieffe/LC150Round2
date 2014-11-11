package Accepted;

import Utils.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode dummy1 = new ListNode(0);
        dummy1.next = l1;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = l2;
        ListNode cNode1 = dummy1;
        ListNode cNode2 = dummy2;
        
        ListNode dummy = new ListNode(0);
        ListNode cNode = dummy;
        boolean larger = false;
        
        while (cNode1.next != null || cNode2.next != null) {
            int tmp = 0;
            if (cNode1.next != null)
                tmp += cNode1.next.val;
            if (cNode2.next != null)
                tmp += cNode2.next.val;
            if (larger == true)
                tmp += 1;
            if (tmp >= 10) {
                larger = true;
                tmp %= 10;
            }
            else
                larger = false;
            cNode.next = new ListNode(tmp);
            cNode = cNode.next;
            if (cNode1.next != null)
                cNode1 = cNode1.next;
            if (cNode2.next != null)
                cNode2 = cNode2.next;
        }
        if (larger)
            cNode.next = new ListNode(1);
        return dummy.next;
    }
}
