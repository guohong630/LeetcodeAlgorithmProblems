package validateBinarySearchTree;

import java.util.ArrayList;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        return helper(root, pre);
    }

    public boolean helper(TreeNode root, ArrayList<TreeNode> pre) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left, pre);
        if (pre.get(0)!=null && root.val<=pre.get(0).val) {
            return false;
        }
        pre.set(0, root);
        boolean right = helper(root.right, pre);
        return left && right;
        
    }
}
