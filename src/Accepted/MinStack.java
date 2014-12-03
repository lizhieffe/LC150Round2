package Accepted;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	List<Integer> min = new ArrayList<Integer>();
    List<Integer> stack = new ArrayList<Integer>();
    
    public void push(int x) {
        stack.add(x);
        if (min.size() == 0 || x <= min.get(min.size() - 1))
            min.add(x);
    }

    public void pop() {
        int x = stack.remove(stack.size() - 1);
        if (x == min.get(min.size() - 1))
            min.remove(min.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}
