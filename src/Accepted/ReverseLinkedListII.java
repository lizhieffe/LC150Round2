package Accepted;

import Utils.ListNode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cNode = dummy;
        ListNode prev = dummy;
        ListNode end = dummy;
        for (int i = 0; i <= n; i++) {
            if (i == m - 1)
                prev = cNode;
            else if (i == n) {
                end = cNode;
                break;
            }
            cNode = cNode.next;
        }
        reverse(prev, end);
        return dummy.next;
    }
    
    private void reverse(ListNode prev, ListNode end) {
        ListNode after = end.next;
        while (prev.next != end) {
            ListNode cNode = prev.next;
            prev.next = cNode.next;
            end.next = cNode;
            cNode.next = after;
            after = end.next;
        }
    }
}
