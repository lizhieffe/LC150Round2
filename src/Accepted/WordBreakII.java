package Accepted;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

	public class WordBreakII {

		List<String> result = new ArrayList<String>();
	    boolean[] impossible;
	    
	    public List<String> wordBreak(String s, Set<String> dict) {
	        if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
	            return result;
	        
	        int maxLength = 0;
	        Iterator<String> it = dict.iterator();
	        while (it.hasNext()) {
	            String tmp = it.next();
	            if (maxLength < tmp.length())
	                maxLength = tmp.length();
	        }
	        
	        this.impossible = new boolean[s.length() + 1];
	        
	        String solution = "";
	        findBreak(solution, s, 0, dict, impossible);
	        return result;
	    }
	    
	    private void findBreak(String solution, String s, int beg, Set<String> dict
	    		, boolean[] impossible) {
	        if (beg >= s.length()) {
	            result.add(solution.substring(0, solution.length() - 1));
	            return;
	        }
	        
	        Iterator<String> it = dict.iterator();
	        while (it.hasNext()) {
	        	String tmp = it.next();
	        	if (beg + tmp.length() <= s.length() && impossible[beg + tmp.length()] == false && s.substring(beg, tmp.length() + beg).equals(tmp)) {
	        		StringBuilder builder = new StringBuilder(solution);
	                builder.append(tmp);
	                builder.append(" ");
	                String newSolution = builder.toString();
	                int lengthBefore = result.size();
	                findBreak(newSolution, s, beg + tmp.length(), dict, impossible);
	                if (lengthBefore == result.size())
	                	impossible[beg + tmp.length()] = true;
	        	}
	        }
	    }
    
    public static void main(String[] args) {
    	String s = "a";
    	Set<String> dict = new HashSet<String>();
    	dict.add("a");
    	new WordBreakII().wordBreak(s, dict);
    }
}
