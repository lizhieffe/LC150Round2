package Accepted;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringWithTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() <= 2)
			return s.length();
		Map<Character, Integer> pos = new HashMap<Character, Integer>();
		int start = 0;
		int end = -1;
		Character last = null;
		int result = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (!pos.containsKey(s.charAt(i))) {
				if (pos.size() == 2) {
					end = i - 1;
					break;
				}
				else
					pos.put(s.charAt(i), i);
			}
			else {
				if (last != (Character)s.charAt(i)) {
					pos.put(s.charAt(i), i);
					last = s.charAt(i);
				}
			}
		}
		if (end == -1)
			return s.length();
		for (int i = end + 1; i < s.length(); ++i) {
			if (!pos.containsKey(s.charAt(i))) {
				end = i - 1;
				if (end - start + 1> result)
					result = end - start;
				start = pos.get(last);
				pos.clear();
				pos.put(last, start);
				pos.put(s.charAt(i), i);
			}
			else {
				if (last != (Character)s.charAt(i)) {
					pos.put(s.charAt(i), i);
					last = s.charAt(i);
				}
			}
		}
		if (s.length() - start > result)
			result = s.length() - start;
		return result;
	}
	
	@Test
	public void tc01() {
		String s = "eceba";
		LongestSubstringWithAtMostTwoDistinctCharacters service
			= new LongestSubstringWithAtMostTwoDistinctCharacters();
		int result = service.lengthOfLongestSubstringWithTwoDistinct(s);
		assertTrue(result == 3);
	}
}
