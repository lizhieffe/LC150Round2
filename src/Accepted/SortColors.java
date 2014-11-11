package Accepted;

public class SortColors {

	public void sortColors(int[] A) {
        int nRed = 0;
        int nWhite = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                nRed++;
            else if (A[i] == 1)
                nWhite++;
        }
        for (int i = 0; i < A.length; i++) {
            if (i < nRed)
                A[i] = 0;
            else if (i < nRed + nWhite)
                A[i] = 1;
            else
                A[i] = 2;
        }
    }
}
