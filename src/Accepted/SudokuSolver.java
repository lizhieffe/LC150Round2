package Accepted;

public class SudokuSolver {

	char[][] board;
	
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length)
            return;
        
        this.board = board;
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n * n; i ++) {
            int x = i / n;
            int y = i % n;
            if (board[x][y] == '.') {
                char[] possibleChars = findPossibleChars(board, x, y);
                if (possibleChars == null || possibleChars.length == 0)
                    return false;
                else {
                    for (int j = 0; j < possibleChars.length; j ++) {
                        char[][] newBoard = new char[n][n];
                        System.arraycopy(board, 0, newBoard, 0, n);
                        newBoard[x][y] = possibleChars[j];
                        if (solve(newBoard))
                        	return true;
                    }
                }
            }
        }
        this.board = board;
        return true;
    }
    
    private char[] findPossibleChars(char[][] board, int x, int y) {
        boolean[] occupied = new boolean[9];
        for (int i = 0; i < 9; i ++)
            if (board[i][y] != '.')
                occupied[board[i][y] - '1'] = true;
        for (int i = 0; i < 9; i ++)
            if (board[x][i] != '.')
                occupied[board[x][i] - '1'] = true;
        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++)
                if (board[x / 3 + i][y / 3 + j] != '.')
                    occupied[board[x / 3 + i][y / 3 + j] - '1'] = true;
        int n = 0;
        for (int i = 0; i < 9; i ++)
            if (occupied[i] == false)
                n ++;
        if (n == 0)
            return null;
        char[] result = new char[n];
        int j = 0;
        for (int i = 0; i < 9; i ++)
            if (occupied[i] == false) {
                result[j ++] = (char)('1' + i);
            }
        return result;
    }
    
    public static void main(String[] args) {
    	String[] strings = {"..9748...","7........",".2.1.9...",
    			"..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	
    	char[][] board = new char[9][9];
    	
    	for (int i = 0; i < 9; i ++)
    		board[i] = strings[i].toCharArray();    
    
    	new SudokuSolver().solveSudoku(board);
    	System.out.println();
    }
}
