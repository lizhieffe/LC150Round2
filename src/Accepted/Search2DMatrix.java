package Accepted;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        return searchMatrix(matrix, 0, matrix.length - 1, target);
    }
    
    private boolean searchMatrix(int[][] matrix, int beg, int end, int target) {
        if (beg > end)
            return false;
        if (beg == end)
            return searchArray(matrix[beg], target);
        int mid = beg + (end - beg) / 2;
        if (matrix[mid][0] > target)
            return searchMatrix(matrix, beg, mid - 1, target);
        if (matrix[mid][matrix[0].length - 1] < target)
            return searchMatrix(matrix, mid + 1, end, target);
        return searchArray(matrix[mid], target);
    }
    
    private boolean searchArray(int[] array, int target) {
        return searchArray(array, 0, array.length - 1, target);
    }
    
    private boolean searchArray(int[] array, int beg, int end, int target) {
        if (beg > end)
            return false;
        if (beg == end)
            return array[beg] == target ? true : false;
        if (target > array[end] || target < array[beg])
            return false;
        int mid = beg + (end - beg) / 2;
        if (array[beg] == target || array[end] == target || array[mid] == target)
            return true;
        if (array[mid] < target)
            return searchArray(array, mid + 1, end, target);
        else
            return searchArray(array, beg, mid - 1, target);
    }
}
