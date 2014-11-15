package Accepted;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                if (board[i][j] == word.charAt(0) && search(board, word, 0, i, j, visited))
                    return true;
                visited[i][j] = false;
            }
        return false;
    }
    
    private boolean search(char[][] board, String word, int beg, int i, int j, boolean[][] visited) {
        if (beg >= word.length() - 1)
            return true;
            
        if (i > 0 && board[i - 1][j] == word.charAt(beg + 1) && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            if (search(board, word, beg + 1, i - 1, j, visited))
                return true;
            visited[i - 1][j] = false;
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(beg + 1) && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            if (search(board, word, beg + 1, i + 1, j, visited))
                return true;
            visited[i + 1][j] = false;
        }
        if (j > 0 && board[i][j - 1] == word.charAt(beg + 1) && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            if (search(board, word, beg + 1, i, j - 1, visited))
                return true;
            visited[i][j - 1] = false;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(beg + 1) && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            if (search(board, word, beg + 1, i, j + 1, visited))
                return true;
            visited[i][j + 1] = false;
        }
        return false;
    }
}
