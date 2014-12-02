package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Utils.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> solution = new ArrayList<Integer>();
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                solution.add(node.val);
                if (node.left != null)
                    tmpQueue.add(node.left);
                if (node.right != null)
                    tmpQueue.add(node.right);
            }
            result.add(0, solution);
            Queue<TreeNode> tmp = queue;
            queue = tmpQueue;
            tmpQueue = tmp;
        }
        return result;
    }
}
