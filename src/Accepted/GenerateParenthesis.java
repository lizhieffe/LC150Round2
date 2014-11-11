package Accepted;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0)
            return result;
        generate(n, n, result, "");
        return result;
    }
    
    private void generate(int i, int j, List<String> result, String solution) {
        if (i == 0 && j == 0) {
            result.add(solution);
            return;
        }
        if (i > 0) {
            String tmp = new String(solution);
            tmp += "(";
            generate(i - 1, j, result, tmp);
        }
        if (j > 0 && i < j) {
            String tmp = new String(solution);
            tmp += ")";
            generate(i, j - 1, result, tmp);
        }
    }
}
