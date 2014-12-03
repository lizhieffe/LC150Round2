package Accepted;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {

	public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        List<Character> stack = new ArrayList<Character>();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{')
                stack.add(c[i]);
            else if (c[i] == ')') {
                if (stack.size() == 0 || stack.remove(stack.size() - 1) != '(')
                    return false;
            }
            else if (c[i] == ']') {
                if (stack.size() == 0 || stack.remove(stack.size() - 1) != '[')
                    return false;
            }
            else if (c[i] == '}') {
                if (stack.size() == 0 || stack.remove(stack.size() - 1) != '{')
                    return false;
            }
        }
        if (stack.size() > 0)
            return false;
        return true;
    }
}
