package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        goLeft(root, stack, result);
        while (stack.size() > 0)
            goLeft(stack.remove(stack.size() - 1).right, stack, result);
        return result;
    }
    
    private void goLeft(TreeNode n, List<TreeNode> stack, List<Integer> result) {
        if (n == null)
            return;
        while (n != null) {
            result.add(n.val);
            stack.add(n);
            n = n.left;
        }
    }
}
