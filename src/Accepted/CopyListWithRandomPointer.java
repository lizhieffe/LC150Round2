package Accepted;

import java.util.HashMap;

import Utils.RandomListNode;

public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		 if (head == null)
		    return null;
		 RandomListNode dummy = new RandomListNode(0);
		 RandomListNode dummyNew = new RandomListNode(0);
		 RandomListNode cur = dummyNew;
		 dummy.next = head;
		 HashMap<RandomListNode, RandomListNode> rel = new HashMap<RandomListNode, RandomListNode>();
		 while (dummy.next != null) {
		     dummy = dummy.next;
		     RandomListNode tmp = new RandomListNode(dummy.label);
		     tmp.random = dummy.random;
		     rel.put(dummy, tmp);
		     cur.next = tmp;
		     cur = cur.next;
		 }
		 cur = dummyNew.next;
		 while (cur != null) {
		     cur.random = rel.get(cur.random);
		     cur = cur.next;
		 }
		 return dummyNew.next;
   }
}
