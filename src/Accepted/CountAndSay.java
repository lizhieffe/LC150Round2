package Accepted;

public class CountAndSay {

	public String countAndSay(int n) {
        if (n <= 0)
            return "";
        String s = "1";
        for (int i = 1; i < n; i++)
            s = countAndSay(s);
        return s;
    }
    public String countAndSay(String s) {
        char[] c = s.toCharArray();
        char prev = ((int)c[0] - 0) > 0 ? '0' : '1';
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (prev != c[i]) {
                if (i != 0) {
                    builder.append(count);
                    builder.append(prev);
                }
                count = 1;
                prev = c[i];
            }
            else
                count++;
        }
        builder.append(count);
        builder.append(prev);
        return builder.toString();
    }
}
