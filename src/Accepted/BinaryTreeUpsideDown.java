package Accepted;

import org.junit.Test;

import Utils.TreeNode;

public class BinaryTreeUpsideDown {
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return right;
		TreeNode tmp = new TreeNode(root.val);
		tmp.left = left;
		tmp.right = right;
		left = root.right;
		right = tmp;
		return UpsideDownBinaryTree(root.left);
	}
	
	@Test
	public void tc01() {
		TreeNode n0 = new TreeNode(1);
		n0.left = new TreeNode(2);
		n0.right = new TreeNode(3);
		n0.left.left = new TreeNode(4);
		n0.left.right = new TreeNode(5);
		TreeNode result = new BinaryTreeUpsideDown().UpsideDownBinaryTree(n0);
		System.out.println();
	}
}
