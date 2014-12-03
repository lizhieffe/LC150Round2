package Accepted;

public class LongestParlindromeSubstring {

	public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        char[] c = s.toCharArray();
        int max = 0;
        int beg = 0;
        for (int i = 0; i < s.length(); i++) {
        	int tmpMax = findMax(c, i);
        	if (max < tmpMax) {
        		max = tmpMax;
        		beg = i - ((int)tmpMax / 2);
        	}
        }
        for (int i = 0; i < s.length() - 1; i++) {
        	int tmpMax = findMax(c, i, i + 1);
        	if (max < tmpMax) {
        		max = tmpMax;
        		beg = i - ((int)tmpMax / 2) + 1;
        	}
        }
        return s.substring(beg, beg + max);
    }
	
	private int findMax(char[] c, int mid) {
		int max = 1;
		for (int i = 1; i <= mid && i < c.length - mid; i++) {
			if (c[mid - i] == c[mid + i])
				max += 2;
			else
				break;
		}
		return max;
	}
	
	private int findMax(char[] c, int beg, int end) {
		int max = 0;
		for (int i = 0; i <= beg && i < c.length - end; i++) {
			if (c[beg - i] == c[end + i])
				max += 2;
			else
				break;
		}
		return max;
	}
	
	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(new LongestParlindromeSubstring().longestPalindrome(s));
	}
}
