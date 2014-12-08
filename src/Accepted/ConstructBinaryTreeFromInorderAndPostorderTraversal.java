package Accepted;

import Utils.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length)
            return null;
        return findRoot(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode findRoot(int[] inorder, int beg1, int end1, int[] postorder, int beg2, int end2) {
        if (beg1 > end1)
            return null;
        if (beg1 == end1)
            return new TreeNode(inorder[beg1]);
        int val = postorder[end2];
        int index1 = findVal(inorder, beg1, end1, val);
        TreeNode result = new TreeNode(val);
        result.left = findRoot(inorder, beg1, index1 - 1, postorder, beg2, beg2 + index1 - beg1 - 1);
        result.right = findRoot(inorder, index1 + 1, end1, postorder, beg2 + index1 - beg1, end2 - 1);
        return result;
    }
    
    private int findVal(int[] array, int beg, int end, int val) {
        for (int i = beg; i <= end; i++)
            if (array[i] == val)
                return i;
        return -1;
    }
}
