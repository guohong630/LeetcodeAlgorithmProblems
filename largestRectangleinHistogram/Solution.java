package largestRectangleinHistogram;

import java.util.Stack;

public class Solution {
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int index = stack.pop();
                int curArea = stack.isEmpty()? i*height[index] : (i - stack.peek() - 1) * height[index];
                max = Math.max(max, curArea);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int curArea = stack.isEmpty()? height.length*height[index] : (height.length - stack.peek() - 1) * height[index];
            max = Math.max(max, curArea);
        }
        
        return max;
    }
    
    public static void main(String args[]) {
        int[] height = new int[]{2,1,5,6,2,3};
        System.out.println(Solution.largestRectangleArea(height));
    }
}