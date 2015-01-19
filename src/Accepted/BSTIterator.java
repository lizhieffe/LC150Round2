package Accepted;

import java.util.Stack;

import Utils.TreeNode;

public class BSTIterator {

Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        goToLeftMostChild(root, stack);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() == 0 ? false : true;
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext())
            return -1;
        TreeNode last = stack.pop();
        if (last.right != null)
            goToLeftMostChild(last.right, stack);
        return last.val;
    }
    
    private void goToLeftMostChild(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
