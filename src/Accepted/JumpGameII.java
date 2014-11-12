package Accepted;

public class JumpGameII {

	public int jump(int[] A) {
        if (A.length <= 1)
            return 0;
        int beg = 0;
        int end = 0;
        int result = 0;
        while (end < A.length - 1) {
            int newEnd = end;
            for (int i = beg; i <= end; i++) {
                if (beg + A[beg] > newEnd)
                    newEnd = beg + A[beg];
            }
            if (newEnd <= end) {
                return -1;
            }
            beg = end + 1;
            end = newEnd;
            result++;
        }
        return result;
    }
}
