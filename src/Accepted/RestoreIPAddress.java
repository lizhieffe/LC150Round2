package Accepted;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return result;
        List<String> solution = new ArrayList<String>();
        restore(s, 0, solution, result);
        return result;
    }
    
    private void restore(String s, int beg, List<String> solution, List<String> result) {
        if (solution.size() == 4 && beg == s.length()) {
            String tmp = solution.get(0) + '.' + solution.get(1) + '.' + solution.get(2) + '.' + solution.get(3);
            result.add(tmp);
            return;
        }
        if (solution.size() == 4 || beg >= s.length())
            return;
        for (int i = beg; i < beg + Math.min(3, s.length() - beg); i++) {
            String tmpString = s.substring(beg, i + 1);
            if ((Integer.parseInt(tmpString) <= 255) && (i == beg || tmpString.charAt(0) != '0')) {
                List<String> tmpSolution = new ArrayList<String>(solution);
                tmpSolution.add(tmpString);
                restore(s, i + 1, tmpSolution, result);
            }
        }
    }
    
    public static void main(String[] args) {
    	String s = "010010";
    	new RestoreIPAddress().restoreIpAddresses(s);
    }
}
