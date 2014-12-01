package Accepted;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() != end.length())
            return 0;
        if (start.equals(end))
            return 2;
        Queue<StringNCount> queue = new LinkedList<StringNCount>();
        queue.add(new StringNCount(start, 1));
        while (queue.size() > 0) {
            StringNCount sc = queue.poll();
            String s = sc.s;
            int n = sc.n;
            if (s.equals(end))
                return n;
            else {
                addNeighbors(queue, s, n + 1, dict);
            }
        }
        return 0;
    }
    
    private void addNeighbors(Queue<StringNCount> queue, String s, int n, Set<String> dict) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                StringBuilder b = new StringBuilder(s);
                b.setCharAt(i, (char)('a' + j));
                String tmp = b.toString();
                if (dict.contains(tmp)) {
                    queue.add(new StringNCount(b.toString(), n));
                    dict.remove(tmp);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dog");
    	String start = "hot";
    	String end = "dog";
    	System.out.println(new WordLadder().ladderLength(start, end, dict));
    }
}


class StringNCount {
    String s;
    int n;
    StringNCount (String s, int n) {
        this.s = s;
        this.n = n;
    }
}
