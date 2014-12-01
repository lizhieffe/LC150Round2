package ETL;

public class LongestSubstringWithoutRepeatingCharacters {

	private int maxLength = 0;

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] count = new int[256];
        startSearch(s, 0, count, 0);
        return maxLength;
    }
    
    private void startSearch(String s, int beg, int[] count, int length) {
        for (int i = beg; i < s.length(); i++) {
            int tmp  = (int)s.charAt(i);
            if (count[tmp] != 0) {
                maxLength = Math.max(maxLength, length);
                count[tmp] = 0;
                startSearch(s, i, count, length - 1);
            }
            else {
                length++;
                count[tmp]++;
            }
        }
        maxLength = Math.max(maxLength, length);
    }
    
    public static void main(String[] args) {
    	String s = "abcad";
    	System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
