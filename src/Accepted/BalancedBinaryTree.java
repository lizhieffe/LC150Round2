package Accepted;

import Utils.TreeNode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
        return height(root) == -1 ? false : true;
    }
    
    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int left = height(node.left);
        if (left == -1)
            return -1;
        int right = height(node.right);
        if (right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
