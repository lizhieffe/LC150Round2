package Accepted;

import Utils.TreeNode;

public class RecoveryBinarySearchTree {

	TreeNode first, second;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        search(root);
        swap(first, second);
    }
    
    private void search(TreeNode node) {
        if (node.left != null)
            search(node.left);
        if (node.val < prev.val) {
            if (first == null) {
                first = prev;
                second = node;
            }
            else {
                second = node;
                return;
            }
        }
        prev = node;
        if (node.right != null)
            search(node.right);
    }
    
    private void swap(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
