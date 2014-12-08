package Accepted;

public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                	if (j == 0)
                		firstColumnZero = true;
                    else
                    	matrix[0][j] = 0;
                    if (i == 0)
                        firstRowZero = true;
                    else
                        matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++)
            if (matrix[0][i] == 0)
                setColumn(matrix, i, 0);
        for (int i = 1; i < matrix.length; i++)
            if (matrix[i][0] == 0)
                setRow(matrix, i, 0);
        if (firstColumnZero)
        	setColumn(matrix, 0, 0);
        if (firstRowZero)
            setRow(matrix, 0, 0);
    }
    
    private void setRow(int[][] matrix, int row, int val) {
        for (int i = 0; i < matrix[0].length; i++)
            matrix[row][i] = val;
    }
    
    private void setColumn(int[][] matrix, int column, int val) {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][column] = val;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
    	new SetMatrixZeros().setZeroes(matrix);
    	System.out.println(matrix);
    }
}
