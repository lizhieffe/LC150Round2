package Accepted;

public class ReverseWordInString {

	public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] sep = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sep.length; i++) {
        	if (!sep[i].equals("")) {

        		builder.insert(0, sep[i]);
        		if (i != sep.length - 1)
            		builder.insert(0, " ");
        	}
        }
        String result = builder.toString();
        return result;
    }
	
	public static void main(String[] args) {
		String s = "th sk    1";
		System.out.println(new ReverseWordInString().reverseWords(s));
	}
}
