package Accepted;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import Utils.ListNode;

public class MergeKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        if (lists == null || lists.size() == 0)
            return dummy.next;
        if (lists.size() == 1)
            return lists.get(0);
        ListNode resultNode = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
        for (int i = 0; i < lists.size(); i ++) {
            ListNode node = lists.get(i);
            if (node != null) {
                pq.add(node);
            }
        }
        
        while (pq.size() > 0) {
            ListNode n = pq.poll();
            resultNode.next = n;
            resultNode = resultNode.next;
            
            if (n.next != null)
                pq.add(n.next);
        }
        
        return dummy.next;
    }
}

	class ListNodeComparator implements Comparator <ListNode> {
    public int compare(ListNode l1, ListNode l2) {
        if (l1.val < l2.val)
            return -1;
        else if (l1.val == l2.val)
            return 0;
        else
            return 1;
    }
}
