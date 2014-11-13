package Accepted;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null)
            return result;
        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        return letterCombinations(digits, 0);
    }
    
    private List<String> letterCombinations(String digits, int beg) {
        if (beg == digits.length() - 1)
            return getRepresents(digits.charAt(beg));
        List<String> s1 = getRepresents(digits.charAt(beg));
        List<String> s2 = letterCombinations(digits, beg + 1);
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < s1.size(); i++)
            for (int j = 0; j < s2.size(); j++)
                result.add(s1.get(i) + s2.get(j));
        return result;
    }
    
    private List<String> getRepresents(char c) {
        List<String> result = new ArrayList<String>();
        if (c == '2') {
            result.add("a");
            result.add("b");
            result.add("c");
        }
        else if (c == '3') {
            result.add("d");
            result.add("e");
            result.add("f");
        }
        else if (c == '4') {
            result.add("g");
            result.add("h");
            result.add("i");
        }
        else if (c == '5') {
            result.add("j");
            result.add("k");
            result.add("l");
        }
        else if (c == '6') {
            result.add("m");
            result.add("n");
            result.add("o");
        }
        else if (c == '7') {
            result.add("p");
            result.add("q");
            result.add("r");
            result.add("s");
        }
        else if (c == '8') {
            result.add("t");
            result.add("u");
            result.add("v");
        }
        else if (c == '9') {
            result.add("w");
            result.add("x");
            result.add("y");
            result.add("z");
        }
        
        return result;
    }
}
