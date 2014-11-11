package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeLinkNode;

public class PopulatingNextRightPointsInEachNode {

	public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        root.next = null;
        List<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
        List<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
        queue.add(root);
        while (queue.size() > 0) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.get(i).next = queue.get(i + 1);
            }
            queue.get(queue.size() - 1).next = null;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i).left != null)
                    tmp.add(queue.get(i).left);
                if (queue.get(i).right != null)
                    tmp.add(queue.get(i).right);
            }
            queue.clear();
            List<TreeLinkNode> exchange = queue;
            queue = tmp;
            tmp = exchange;
        }
    }
}
