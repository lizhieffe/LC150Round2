package Accepted;

public class TrappingRainWater {

	public int trap(int[] A) {
        if (A == null || A.length <= 2)
            return 0;
        int start = 0;
        int totalHeight = 0;
        int i = 1;
        int result = 0;
        int boundary = A[0];
        boolean[] finished = new boolean[A.length];
        
        while (i < A.length) {
            if (A[i] < boundary)
                totalHeight += A[i];
            else {
            	if (A[i] == A[start]) {
            		finished[i] = true;
            		finished[start] = true;
            	}
                result += (i - start - 1) * boundary - totalHeight;
                start = i;
                totalHeight = 0;
                boundary = A[i];
            }
            i ++;
        }
        
        start = A.length - 1;
        i = A.length - 2;
        totalHeight = 0;
        boundary = A[start];
        
        while (i >= 0) {
            if (A[i] < boundary)
                totalHeight += A[i];
            else {
            	if (A[i] == boundary && !(finished[start] && finished[i]))
                    result += (start - i - 1) * boundary - totalHeight;
            	else if (A[i] != boundary)
                    result += (start - i - 1) * boundary - totalHeight;
                start = i;
                totalHeight = 0;
                boundary = A[i];
            }
            i --;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(A));
	}
}
