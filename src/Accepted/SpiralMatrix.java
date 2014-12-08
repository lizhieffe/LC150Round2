package Accepted;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        int falseCount = 0;
        int direction = 0;
        int i = 0;
        int j = -1;
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        while (falseCount < 4) {
            if (direction == 0) {
                if (j < columns - 1 && visited[i][j + 1] == false) {
                    result.add(matrix[i][j + 1]);
                    falseCount = 0;
                    visited[i][j + 1] = true;
                    j++;
                }
                else {
                    falseCount++;
                    direction = 1;
                }
            }
            else if (direction == 1) {
                if (i < rows - 1 && visited[i + 1][j] == false) {
                    result.add(matrix[i + 1][j]);
                    falseCount = 0;
                    visited[i + 1][j] = true;
                    i++;
                }
                else {
                    falseCount++;
                    direction = 2;
                }
            }
            else if (direction == 2) {
                if (j > 0 && visited[i][j - 1] == false) {
                    result.add(matrix[i][j - 1]);
                    falseCount = 0;
                    visited[i][j - 1] = true;
                    j--;
                }
                else {
                    falseCount++;
                    direction = 3;
                }
            }
            else if (direction == 3) {
                if (i > 0 && visited[i - 1][j] == false) {
                    result.add(matrix[i - 1][j]);
                    falseCount = 0;
                    visited[i - 1][j] = true;
                    i--;
                }
                else {
                    falseCount++;
                    direction = 0;
                }
            }
        }
        return result;
    }
}
