package Accepted;

public class RotateImage {

	public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return;
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
        	for (int j = i; j < n - i - 1; j++)
        		rotate(matrix, i, j);
        }
        System.out.println();
    }

    private void rotate(int[][] matrix, int i, int j) {
    	int n = matrix.length;
    	int v1 = matrix[i][j];
    	int v2 = matrix[j][n - i - 1];
    	int v3 = matrix[n - i - 1][ n - j - 1];
    	int v4 = matrix[n - j - 1][i];
    	matrix[i][j] = v4;
    	matrix[j][n - i - 1] = v1;
    	matrix[n - i - 1][ n - j - 1] = v2;
    	matrix[n - j - 1][i] = v3;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    	new RotateImage().rotate(matrix);
    }
}
