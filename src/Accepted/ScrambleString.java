package Accepted;

import java.util.Arrays;

public class ScrambleString {

	int[][][] isScramble;
    
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        isScramble = new int[s1.length() + 1][s1.length() + 1][s1.length() + 1];
        for (int i = 0; i < s1.length() + 1; i ++)
            for (int j = 0; j < s1.length() + 1; j ++)
            	for (int k = 0; k < s1.length() + 1; k ++)
            		isScramble[i][j][k] = -1;
        return isScramble(s1, s2, 0, s1.length(), 0);
    }
    
    private boolean isScramble(String s1, String s2
    		, int beg1, int end1, int beg2) {
    	int end2 = beg2 + (end1 - beg1);
    	
        if (beg1 >= end1)
            return true;
        
        if (isScramble[beg1][end1][beg2] != -1)
            return isScramble[beg1][end1][beg2] == 0 ? false : true;
        if (beg1 == end1 - 1)
        	return s1.substring(beg1, end1).equals(s2.substring(beg2, end2));
        
        int result = 0;
        char[] char1 = s1.substring(beg1, end1).toCharArray();
        char[] char2 = s2.substring(beg2, end2).toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < end1 - beg1; i ++)
            if (char1[i] != char2[i]) {
            	result = 0;
            	isScramble[beg1][end1][beg2] = result;
            	return false;
            }
        for (int i = beg1; i < end1 - 1; i ++) {
            if (isScramble(s1, s2, beg1, i + 1, beg2) == true && isScramble(s1, s2, i + 1, end1, beg2 + i + 1 - beg1) == true) {
            	isScramble[beg1][end1][beg2] = 1;
            	return true;
            }
            if (isScramble(s1, s2, beg1, i + 1, end2 - (i + 1- beg1)) == true 
            		&& isScramble(s1, s2, i + 1, end1, beg2) == true) {
            	isScramble[beg1][end1][beg2] = 1;
            	return true;
            }
        }
        isScramble[beg1][end1][beg2] = 0;
        return false;
    }
    
    public static void main(String[] args) {
    	String s1 = "bba";
    	String s2 = "abb";
    	System.out.println(new ScrambleString().isScramble(s1, s2));
    }
}
