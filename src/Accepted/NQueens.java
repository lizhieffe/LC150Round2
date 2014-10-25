package Accepted;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();

        if (n <= 0)
            return result;
        
        List<Integer> solution = new ArrayList<Integer>();
        solve(result, solution, n);
        return result;
    }
    
    private void solve(List<String[]> result, List<Integer> solution, int n) {
        if (solution.size() == n) {
            String[] tmp = new String[n];
            for (int i = 0; i < n; i ++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j ++) {
                    if (j == solution.get(i))
                        builder.append('Q');
                    else
                        builder.append('.');
                }
                tmp[i] = builder.toString();
            }
            result.add(tmp);
        }
        
        else {
            for (int i = 0; i < n; i ++) {
                if (isValidPosition(solution, i)) {
                    List<Integer> newSolution = new ArrayList<Integer>(solution);
                    newSolution.add(i);
                    solve(result, newSolution, n);
                }
            }
        }
    }
    
    private boolean isValidPosition(List<Integer> solution, int p) {
        for (int i = 0; i < solution.size(); i ++) {
            int existing = solution.get(i);
            if (existing == p || Math.abs(i - solution.size()) == Math.abs(existing - p))
                return false;
        }
        return true;
    }
}
