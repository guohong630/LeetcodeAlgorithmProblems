package minimumDepthofBinaryTree;

public class Solution {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right)+1;
        }
        if (root.right == null) {
            return minDepth(root.left) +1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
    
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.right = t3;
        t3.left = t4;
        System.out.print(Solution.minDepth(t1));
    }
}

