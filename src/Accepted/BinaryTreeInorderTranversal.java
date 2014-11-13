package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeInorderTranversal {

	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        TreeNode cNode = root;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        while (cNode != null) {
            stack.add(cNode);
            cNode = cNode.left;
        }
        while (stack.size() > 0) {
            TreeNode tmp = stack.remove(stack.size() - 1);
            result.add(tmp.val);
            if (tmp.right != null) {
                cNode = tmp.right;
                while (cNode != null) {
                    stack.add(cNode);
                    cNode = cNode.left;
                }
            }
        }
        return result;
    }
}
