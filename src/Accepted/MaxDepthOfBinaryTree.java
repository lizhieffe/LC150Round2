package Accepted;

import Utils.TreeNode;

public class MaxDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
        return findMaxDepth(root);
    }
    
    private int findMaxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(findMaxDepth(node.left), findMaxDepth(node.right));
    }
}
