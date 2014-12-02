package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode dummy = new TreeNode(-1);
        last = dummy;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        connect(root, stack);
        while (stack.size() > 0) {
            TreeNode tmp = stack.remove(stack.size() - 1);
            if (tmp.right != null)
                connect(tmp.right, stack);
        }
        while (dummy != null) {
            dummy.right = dummy.left;
            dummy.left = null;
            dummy = dummy.right;
        }
    }
    
    private void connect(TreeNode node, List<TreeNode> stack) {
        last.left = node;
        while (node != null) {
            stack.add(node);
            last = node;
            node = node.left;
            
        }
    }
}
