package Accepted;

import Utils.ListNode;

public class ReorderList {

	public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (true) {
            if (fast.next == null)
                break;
            else {
                slow = slow.next;
                fast = fast.next;
            }
            
            if (fast.next == null)
                break;
            else
                fast = fast.next;
        }
        ListNode dummyFastHead = new ListNode(-1);
        dummyFastHead.next = slow.next;
        slow.next = null;
        ListNode newDummyFastHead = new ListNode(0);
        while (dummyFastHead.next != null) {
            ListNode tmpNew = newDummyFastHead.next;
            ListNode tmp = dummyFastHead.next.next;
            newDummyFastHead.next = dummyFastHead.next;
            newDummyFastHead.next.next = tmpNew;
            dummyFastHead.next = tmp;
        }
        ListNode tmp = dummy.next;
        ListNode tmp1 = newDummyFastHead.next;
        while (tmp1 != null) {
            ListNode t = tmp.next;
            tmp.next = tmp1;
            tmp1 = tmp1.next;
            tmp.next.next = t;
            tmp = tmp.next.next;
        }
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		head.next = new ListNode(1);
		head.next = new ListNode(2);
		new ReorderList().reorderList(head);
	}
}
