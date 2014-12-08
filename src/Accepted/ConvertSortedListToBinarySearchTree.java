package Accepted;

import Utils.ListNode;
import Utils.TreeNode;

public class ConvertSortedListToBinarySearchTree {

	ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        curr = dummy;
        return buildBinaryTree(length);
    }

    private TreeNode buildBinaryTree(int length) {
    	if (length == 0)
    		return null;
    	if (length == 1) {
    		TreeNode node = new TreeNode(curr.next.val);
    		curr = curr.next;
    		return node;
    	}
    	int mid = (length - 1) / 2;
    	TreeNode left = buildBinaryTree(mid);
    	TreeNode node = new TreeNode(curr.next.val);
    	curr = curr.next;
    	TreeNode right = buildBinaryTree(length - mid - 1);
    	node.left = left;
    	node.right = right;
    	return node;
    }

    private int getLength(ListNode head) {
    	int result = 0;
    	ListNode curr = head;
    	while (curr != null) {
    		result++;
    		curr = curr.next;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(5);
    	head.next.next = new ListNode(8);
    	new ConvertSortedListToBinarySearchTree().sortedListToBST(head);
    }
}
