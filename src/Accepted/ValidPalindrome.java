package Accepted;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
 		char[] c = s.toCharArray();
 		List<Character> list = new ArrayList<Character>();
 		for (int i = 0; i < c.length; i++) {
 			if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= '0' && c[i] <= '9'))
 				list.add(c[i]);
 			else if (c[i] >= 'A' && c[i] <= 'Z')
 				list.add((char)(c[i] + ('a' - 'A')));
 		}
 		for (int i = 0; i < list.size() / 2; i++) {
 			if (list.get(i) == list.get(list.size() - i - 1)) {
 				continue;
 			}
 			else
 				return false;
 		}
 		return true;
    }
	
	public static void main(String[] args) {
		String s = "8V8K;G;K;V;";
		System.out.println(new ValidPalindrome().isPalindrome(s));
	}
}
