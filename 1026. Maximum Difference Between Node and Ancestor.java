// 1026. Maximum Difference Between Node and Ancestor

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     int finalResult = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        finalResult = helper(root, root.val, root.val);
        return finalResult;
      
    }
    
    public int helper(TreeNode current, int min, int max) {
        if (current == null) {
            return max - min;
        }
        
        int currentDifference = Math.max(Math.abs(current.val - min), Math.abs(current.val - max));
        finalResult = Math.max(finalResult, currentDifference);
        min = Math.min(min, current.val);
        max = Math.max(max, current.val);
        
        int left = helper(current.left, min, max);
        int right = helper(current.right, min, max);     
        
        return Math.max(left, right);
    }
}
