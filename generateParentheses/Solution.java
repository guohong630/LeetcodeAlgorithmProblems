package generateParentheses;

import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop()+stack.pop());
            }
            else if (tokens[i].equals("-")) {
                stack.push(-stack.pop()+stack.pop());
            }
            else if (tokens[i].equals("*")) {
                stack.push(stack.pop()*stack.pop());
            }
            else if (tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
