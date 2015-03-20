package sumRoottoLeafNumber;


public class Solution {
    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        return helper(root, sum);
    }
    
    public static int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            return sum = sum*10+root.val;
        }
        return helper(root.left, sum*10+root.val) + helper(root.right, sum*10+root.val);
    }
    
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.print(Solution.sumNumbers(t1));
    }
}
