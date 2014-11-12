package Accepted;

public class SumRootToLeafNumbers {

	int result = 0;

    public int sumNumbers(TreeNode root) {
    	if (root == null)
    		return result;
    	String tmp = "";
    	sumNumbers(root, tmp);
    	return result;
    }

    private void sumNumbers(TreeNode p, String s) {
    	String tmp = new String(s);
    	tmp += p.val;
    	if (p.left == null && p.right == null) {
    		result += Integer.parseInt(tmp);
    		return;
    	}

    	if (p.left != null)
    		sumNumbers(p.left, tmp);
    	if (p.right != null)
    		sumNumbers(p.right, tmp);
    }
}
