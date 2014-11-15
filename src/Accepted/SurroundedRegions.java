package Accepted;

import java.util.LinkedList;
import java.util.Queue;

/*
 * based on the online solution, this one should be using the right strategy.
 * don't know why etl
 * http://fisherlei.blogspot.com/2013/03/leetcode-surrounded-regions-solution.html
 */

public class SurroundedRegions {

	public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        for (int i = 0; i < board.length; i++) {
            flipToTemp(board, i, 0);
            flipToTemp(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            flipToTemp(board, 0, i);
            flipToTemp(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'I')
                    board[i][j] = 'O';
            }
        System.out.println("Finished");
    }
    
    private void flipToTemp(char[][] board, int x, int y) {
        if (board[x][y] != 'O')
            return;
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        board[x][y] = 'I';
        while (queue.size() > 0) {
            Point p = queue.poll();
            int px = p.x;
            int py = p.y;
            if (px > 0 && board[px - 1][py] == 'O') {
                queue.add(new Point(px - 1, py));
                board[px - 1][py] = 'I';
            }
            if (px < board.length - 1 && board[px + 1][py] == 'O') {
                queue.add(new Point(px + 1, py));
                board[px + 1][py] = 'I';
            }
            if (py > 0 && board[px][py - 1] == 'O') {
                queue.add(new Point(px, py - 1));
                board[px][py - 1] = 'I';
            }
            if (py < board[0].length - 1 && board[px][py + 1] == 'O') {
                queue.add(new Point(px, py + 1));
                board[px][py + 1] = 'I';
            }
        }
    }
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
    	char[] a = new String("XOOXXXOXOO").toCharArray();
    	char[] b = new String("XOXXXXXXXX").toCharArray();
    	char[] c = new String("XXXXOXXXXX").toCharArray();
    	char[] d = new String("XOXXXOXXXO").toCharArray();
    	char[] e = new String("OXXXOXOXOX").toCharArray();
    	char[] f = new String("XXOXXOOXXX").toCharArray();
    	char[] g = new String("OXXOOXOXXO").toCharArray();
    	char[] h = new String("OXXXXXOXXX").toCharArray();
    	char[] i = new String("XOOXXOXXOO").toCharArray();
    	char[] j = new String("XXXOOXOXXO").toCharArray();
    	
    	char[][] board = {a, b, c, d, e, f, g, h, i, j};
    	
    	SurroundedRegions service = new SurroundedRegions();
    	service.solve(board);
    	
    	System.out.println(board);
    }
}
