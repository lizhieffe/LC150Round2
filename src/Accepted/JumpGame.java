package Accepted;

public class JumpGame {

	public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
            return false;
        int val = 0;
        for (int i = 0; i < A.length; i++) {
            val = Math.max(A[i], val - 1);
            if (val <= 0 && i != A.length - 1)
                return false;
        }
        return true;
    }
}
