package Accepted;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+"))
                stack.add(stack.removeLast() + stack.removeLast());
            else if (tokens[i].equals("-"))
                stack.add((-1) * stack.removeLast() + stack.removeLast());
            else if (tokens[i].equals("*"))
                stack.add(stack.removeLast() * stack.removeLast());
            else if (tokens[i].equals("/")) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.add(a / b);
            }
            else
                stack.addLast(Integer.parseInt(tokens[i]));
        }
        return stack.removeLast();
    }
}
