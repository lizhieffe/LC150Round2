package Accepted;

public class ClimbingStairs {

	public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int prev2 = 1;
        int prev = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = prev;
            prev = prev + prev2;
            prev2 = tmp;
        }
        return prev;
    }
}
