package Accepted;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        char[] prefix = strs[0].toCharArray();
        int max = prefix.length;
        for (int i = 1; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            int j = 0;
            for (; j < max && j < tmp.length; j++) {
                if (tmp[j] != prefix[j]) {
                    break;
                }
            }
            max = j;
        }
        return strs[0].substring(0, max);
    }
}
