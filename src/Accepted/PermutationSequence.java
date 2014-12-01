package Accepted;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
        if (n < 1 || n > 9)
            return "";
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++)
            count[i] = count[i - 1] * i;
        if (k > count[n])
            return "";
        int[] index = new int[n + 1];
        k = k - 1;
        for (int i = n; i >= 1; i--) {
            index[i] = k / count[i - 1];
            k = k % count[i - 1];
        }
        List<Character> c = new ArrayList<Character>();
        for (int i = 1; i <= n; i++)
            c.add((char)('0' + i));
        StringBuilder b = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            b.append(c.remove(index[i]));
        }
        return b.toString();
    }
	
	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		System.out.println(new PermutationSequence().getPermutation(n, k));
	}
}
