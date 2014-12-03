package Accepted;

import Utils.ListNode;

public class IntersectionOfTwoLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        int length1 = 1;
        int length2 = 1;
        while (node1.next != null) {
            length1++;
            node1 = node1.next;
        }
        while (node2.next != null) {
            length2++;
            node2 = node2.next;
        }
        if (node1.val != node2.val)
            return null;
        node1 = headA;
        node2 = headB;
        for (int i = 0; i < Math.abs(length1 - length2); i++) {
            if (length1 > length2)
                node1 = node1.next;
            else
                node2 = node2.next;
        }
        while (true) {
            if (node1.val == node2.val)
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }
    }
	
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		ListNode headB = new ListNode(3);
		System.out.println(new IntersectionOfTwoLinkedList().getIntersectionNode(headA, headB).val);
	}
}
