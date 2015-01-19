package Accepted;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompareVersionNumber {

	public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.", 2);
        String[] s2 = version2.split("\\.", 2);
        if (Integer.parseInt(s1[0]) < Integer.parseInt(s2[0]))
            return -1;
        if (Integer.parseInt(s1[0]) > Integer.parseInt(s2[0]))
            return 1;
        if (s1.length > s2.length) {
            if (s2.length == 1)
                return compareVersion(s1[1], "0");
            else
                return compareVersion(s1[1], s2[1]);
        }
        if (s1.length < s2.length) {
            if (s1.length == 1)
                return compareVersion("0", s2[1]);
            else
                return compareVersion(s1[1], s2[1]);
        }
        if (s1.length == 1)
            return 0;
        return compareVersion(s1[1], s2[1]);
    }
	
	@Test
	public void tc01() {
		String version1 = "1.23.23";
		String version2 = "1.56";
		assertTrue(new CompareVersionNumber().compareVersion(version1, version2)
				== -1);
	}
}
