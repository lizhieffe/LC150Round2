package Accepted;

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] c = s.toCharArray();
        int result = 0;
        for (int i = 0; i < c.length; ++i) {
            result = result * 26 + (int)(c[i] - 'A' + 1);
        }
        return result;
    }
}
