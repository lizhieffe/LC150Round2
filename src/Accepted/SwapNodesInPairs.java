package Accepted;

import Utils.ListNode;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode inputHead) {
        if (inputHead == null)
            return inputHead;
        ListNode dummy = new ListNode(0);
        dummy.next = inputHead;
        
        ListNode cNode = dummy;
        
        while (cNode.next != null && cNode.next.next != null) {
            ListNode first = cNode.next;
            ListNode next = cNode.next.next.next;
            cNode.next = cNode.next.next;
            cNode.next.next = first;
            cNode.next.next.next = next;
            cNode = cNode.next.next;
        }
        
        return dummy.next;
    }
}
