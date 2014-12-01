package Accepted;

import Utils.ListNode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        ListNode end = dummy;
        int num = 0;
        while (node != null) {
            end = node;
            node = node.next;
            num++;
        }
        n = n % num;
        if (n == 0)
            return head;
        node = dummy;
        for (int i = 0; i < num - n; i++) {
            node = node.next;
        }
        dummy.next = node.next;
        end.next = head;
        node.next = null;
        return dummy.next;
    }
}
