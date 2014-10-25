package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeLinkNode;

public class PopulatingNextRightPointersII {

	public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        
        List<TreeLinkNode> cur = new ArrayList<TreeLinkNode>();
        List<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
        cur.add(root);
        while (cur.size() > 0) {
            for (int i = 0; i < cur.size(); i ++) {
                TreeLinkNode cNode = cur.get(i);
                if (cNode.left != null)
                    next.add(cNode.left);
                if (cNode.right != null)
                    next.add(cNode.right);
                    
                if (i != cur.size() - 1)
                    cNode.next = cur.get(i + 1);
                else
                    cNode.next = null;
            }
            cur = new ArrayList<TreeLinkNode>(next);
            next.clear();
        }
    }
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		new PopulatingNextRightPointersII().connect(root);

	}
}
