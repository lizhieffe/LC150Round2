package Accepted;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0)
            return result;
        justify(words, 0, L, result);
        return result;
    }
    
    private void justify(String[] words, int beg, int L, List<String> result) {
        int i = beg + 1;
        int n = 1;
        int tmpLength = words[beg].length();
        while (beg + n < words.length) {
            if (tmpLength + words[i].length() + 1 <= L) {
            	tmpLength += words[i].length() + 1;
                n ++;
                i ++;
            }
            else
                break;
        }
        boolean lastLine = (beg + n == words.length) ? true : false;
        restoreResult(words, beg, n, L, result, lastLine);
        if (lastLine == false)
            justify(words, beg + n, L, result);
    }
    
    private void restoreResult(String[] words, int beg, int n, int L, List<String> result, boolean lastLine) {
        String[] padding = new String[n];
        int spacing = L;
        for (int i = beg; i < n + beg; i ++) {
            spacing -= words[i].length();
        }
        if (lastLine == true) {
            for (int i = 0; i < n - 1; i ++)
                padding[i] = " ";
            padding[n - 1] = "";
            for (int i = 0; i < spacing - n + 1; i ++)
                padding[n - 1] += " ";
        }
        else {
            if (n > 1) {
                for (int i = 0; i < n - 1; i ++) {
                    padding[i] = "";
                    for (int j = 0; j < spacing / (n - 1); j ++)
                        padding[i] += " ";
                }
                for (int i = 0; i < spacing % (n - 1); i ++)
                    padding[i] += " ";
                padding[n - 1] = ""; 
            }
             
            else {
            	padding[n - 1] = "";
            	for (int i = 0; i < spacing - n + 1; i ++)
                    padding[n - 1] += " ";
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i ++) 
            builder.append(words[beg + i]).append(padding[i]);
        result.add(builder.toString());
    }
    
    public static void main(String[] args) {
    	String[] words = {"What","must","be","shall","be."};
    	int L = 12;
    	System.out.println(new TextJustification().fullJustify(words, L));
    }
}
