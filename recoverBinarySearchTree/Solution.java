package recoverBinarySearchTree;

import java.util.ArrayList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void recoverTree(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        // otherwise pre.get(0) will have indexOutOfBoundException
        pre.add(null);
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(pre, res, root);
        if (res.size()>0) {
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = temp;
        }
    }
    
    public static void helper(ArrayList<TreeNode> pre, ArrayList<TreeNode> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(pre, res, root.left);
        if (pre.get(0) != null && pre.get(0).val > root.val) {
            if (res.size()==0) {
                res.add(pre.get(0));
                res.add(root);
            }
            else {
                res.set(1, root);
            }
        }
        pre.set(0, root);
        helper(pre, res, root.right);
    }
    
    public static void inOrder(TreeNode root) {
        traverse(root);
        
    }
    
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        System.out.print(root.val);
        traverse(root.right);
    }
    
    public static void main (String args[]) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t3.left = t2;
        t2.left = t4;
        t3.right = t5;
        t5.left = t1;
        t5.right = t6;
        Solution.traverse(t3);
        Solution.recoverTree(t3);
        Solution.traverse(t3);
    }
}