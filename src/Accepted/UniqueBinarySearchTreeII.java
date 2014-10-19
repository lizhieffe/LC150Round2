package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;


public class UniqueBinarySearchTreeII {

	public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
            
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int beg, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
    
        if (beg > end)
            return result;
            
        if (end == beg) {
            result.add(new TreeNode(beg));
            return result;
        }
        
        for (int i = beg; i <= end; i ++) {
            List<TreeNode> tmp1 = generateTrees(beg, i - 1);
            List<TreeNode> tmp2 = generateTrees(i + 1, end);
            if (tmp1.size() == 0) {
                for (int j = 0; j < tmp2.size(); j ++) {
                    TreeNode node = new TreeNode(i);
                    node.right = tmp2.get(j);
                    result.add(node);
                }
            }
            else if (tmp2.size() == 0) {
                for (int j = 0; j < tmp1.size(); j ++) {
                    TreeNode node = new TreeNode(i);
                    node.left = tmp1.get(j);
                    result.add(node);
                }
            }
            else {
                for (int j = 0; j < tmp1.size(); j ++) {
                    for (int k = 0; k < tmp2.size(); k ++) {
                        TreeNode node = new TreeNode(i);
                        node.left = tmp1.get(j);
                        node.right = tmp2.get(k);
                        result.add(node);
                    }
                }
            }
        }
        
        return result;
    }
}
