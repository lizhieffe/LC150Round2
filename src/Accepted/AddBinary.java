package Accepted;

public class AddBinary {

	public String addBinary(String a, String b) {
	    
		if (a == null)
			return b;
		if (b == null)
			return a;
		int length = Math.max(a.length(), b.length()) + 1;
		int[] c1 = new int[length];
		int[] c2 = new int[length];
		char[] t1 = a.toCharArray();
		char[] t2 = b.toCharArray();
		int[] result = new int[length];
		for (int i = 0; i < t1.length; i++)
			c1[c1.length - i - 1] = (t1[t1.length - i - 1] == '0') ? 0 : 1;
		for (int i = 0; i < t2.length; i++)
			c2[c2.length - i - 1] = (t2[t2.length - i - 1] == '0') ? 0 : 1;	
		int mod = 0;
		for (int i = 0; i < length; i++) {
			result[length - i - 1] = (mod + c1[length - i - 1] + c2[length - i - 1]) % 2;
			mod = (mod + c1[length - i - 1] + c2[length - i - 1]) / 2;
		}
		StringBuilder sb = new StringBuilder();
		if (result[0] == 1)
			sb.append(1);
		for (int i = 1; i < length; i++)
			sb.append(result[i]);
		return sb.toString();
   	}
	
	public static void main(String[] args) {
		String a = "0";
		String b = "1";
		System.out.println(new AddBinary().addBinary(a, b));
	}
}
