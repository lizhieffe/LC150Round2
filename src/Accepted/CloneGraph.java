package Accepted;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Utils.UndirectedGraphNode;

public class CloneGraph {
	HashMap<UndirectedGraphNode, Integer> flag = new HashMap<UndirectedGraphNode, Integer>();
    HashMap<UndirectedGraphNode, UndirectedGraphNode> clones = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)    
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        setColor(node, 1);
        while (queue.size() > 0) {
            UndirectedGraphNode cNode = queue.poll();
            setColor(cNode, 2);
            for (int i = 0; i < cNode.neighbors.size(); i++) {
                getClone(cNode).neighbors.add(getClone(cNode.neighbors.get(i)));
                if (getColor(cNode.neighbors.get(i)) == 0) {
                    setColor(cNode.neighbors.get(i), 1);
                    queue.add(cNode.neighbors.get(i));
                }
            }
        }
        return getClone(node);
    }
    
    private UndirectedGraphNode getClone(UndirectedGraphNode node) {
        UndirectedGraphNode toReturn;
        if ((toReturn = clones.get(node)) == null) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            clones.put(node, newNode);
            return newNode;
        }
        return toReturn;
    }
    
    private void setColor(UndirectedGraphNode node, int i) {
        flag.put(node, i);
    }
    
    private int getColor(UndirectedGraphNode node) {
        Integer tmp;
        if ((tmp = flag.get(node)) == null)
            return 0;
        return tmp;
    }
}
