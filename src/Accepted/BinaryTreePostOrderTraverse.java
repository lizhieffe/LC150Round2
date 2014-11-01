package Accepted;

import java.util.ArrayList;
import java.util.List;
import Utils.TreeNode;

public class BinaryTreePostOrderTraverse {

	List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return result;
        startTraverse(root);
        return result;
    }
    
    private void startTraverse(TreeNode node) {
        if (node.left != null)
            startTraverse(node.left);
        if (node.right != null)
            startTraverse(node.right);
        result.add(node.val);
    }
}
