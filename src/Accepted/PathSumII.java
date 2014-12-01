package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        List<Integer> solution = new ArrayList<Integer>();
        findAllPath(root, sum, solution, result);
        return result;
    }
    
    private void findAllPath(TreeNode cNode, int sum, List<Integer> solution, List<List<Integer>> result) {
        List<Integer> tmpSolution = new ArrayList<Integer>(solution);
        tmpSolution.add(cNode.val);
        if (cNode.left == null && cNode.right == null && sum == cNode.val) {
            result.add(tmpSolution);
            return;
        }
        if (cNode.left != null) {
            findAllPath(cNode.left, sum - cNode.val, tmpSolution, result);
        }
        if (cNode.right != null) {
            findAllPath(cNode.right, sum - cNode.val, tmpSolution, result);
        }
    }
}
