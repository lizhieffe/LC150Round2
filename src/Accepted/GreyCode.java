package Accepted;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {

	public List<Integer> grayCode(int n) {
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i <= n; i ++) {
            if (i == 0)
                tmp.add("0");
            else if (i == 1)
                tmp.add("1");
            else {
                int num = tmp.size();
                for (int j = num - 1; j >= 0; j--) {
                    tmp.add("1" + tmp.get(j));
                    tmp.set(j, "0" + tmp.get(j));
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < tmp.size(); i ++)
            result.add(Integer.parseInt(tmp.get(i), 2));
        return result;
    }
}
