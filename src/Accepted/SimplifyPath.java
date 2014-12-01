package Accepted;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

	 public String simplifyPath(String path) {
	        if (path == null || path.length() == 0)
	            return "/";
	        String[] s = path.split("/");
	        List<String> stack = new ArrayList<String>();
	        for (int i = 0; i < s.length; i++) {
	            if (s[i].length() == 0 || s[i].equals("."))
	                continue;
	            if (s[i].equals("..")) {
	                if (stack.size() > 0)
	                    stack.remove(stack.size() - 1);
	                continue;
	            }
	            stack.add(s[i]);
	        }
	        StringBuilder b = new StringBuilder();
	        for (int i = 0; i < stack.size(); i++) {
	            b.append('/');
	            b.append(stack.get(i));
	        }
	        return b.toString().length() == 0 ? "/" : b.toString();
	    }
	 
}
