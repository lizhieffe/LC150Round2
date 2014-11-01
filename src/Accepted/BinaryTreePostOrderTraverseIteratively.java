package Accepted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreePostOrderTraverseIteratively {

	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null)
            return result;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> state = new LinkedList<Integer>();
        
        stack.add(root);
        state.add(1);
        
        traverseLeftChildren(root, stack, state);
        
        while (stack.size() > 0) {
            if (state.getLast() == 1) {
                if (stack.getLast().right == null) {
                    state.removeLast();
                    state.addLast(2);
                }
                else {
                    state.removeLast();
                    state.addLast(2);
                    stack.addLast(stack.getLast().right);
                    state.addLast(1);

                    traverseLeftChildren(stack.getLast(), stack, state);
                }
            }
            else {
                result.add(stack.removeLast().val);
                state.removeLast();
            }
        }
        return result;
    }
    
    private void traverseLeftChildren(TreeNode node, LinkedList<TreeNode> stack, LinkedList<Integer> state) {
        while (node.left != null) {
            stack.add(node.left);
            state.add(1);
            node = node.left;
        }
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	System.out.println(new BinaryTreePostOrderTraverseIteratively()
    			.postorderTraversal(root));
    			
    }
}
