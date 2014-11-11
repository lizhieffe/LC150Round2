package ETL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {

	private int[] dp;
    
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
            return false;
        dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i] = -1;
        int maxLength = 0;
        Iterator<String> it = dict.iterator();
        while (it.hasNext()) {
        	String tmp = it.next();
        	if (tmp.length() > maxLength)
        		maxLength = tmp.length();
        }
        return wordBreak(s, dict, 0, maxLength);
    }
    
    private boolean wordBreak(String s, Set<String> dict, int beg, int maxLength) {
        if (beg >=  s.length())
            return true;
        if (dp[beg] != -1)
            return dp[beg] == 1 ? true : false;
        if (dict.contains(s.substring(beg))) {
        	dp[beg] = 1;
            return true;
        }
        	
        for (int i = beg; i < s.length() && i <= maxLength + beg; i ++) {
            String tmp = s.substring(beg, i + 1);
        	System.out.println(tmp);
            if (dict.contains(tmp) && wordBreak(s, dict, i + 1, maxLength)) {
                dp[beg] = 1;
                return true;
            }
        }
        dp[beg] = 0;
        return false;
    }
    
    public static void main(String[] args) {
    	String s = "a";
    	String[] array = {"b"};
    	Set<String> dict = new HashSet<String>(Arrays.asList(array));
    	System.out.println(new WordBreak().wordBreak(s, dict));
    	
    }
}
