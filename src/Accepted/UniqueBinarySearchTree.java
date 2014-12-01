package Accepted;

public class UniqueBinarySearchTree {

	public int numTrees(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] += count[j - 1] * count[i - j];
            }
        }
        return count[n];
    }
	
	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTree().numTrees(3));
	}
}
