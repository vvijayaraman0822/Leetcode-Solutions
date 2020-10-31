// 104. Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
           return 0;
        }
        
        int left = maxDepth(root.left); // traverse to the leaf node on the left
        int right = maxDepth(root.right); // traverse to the leaf node on the right
        
        return Math.max(left, right) + 1; // add one at the end once recursion stack starts popping
         
        
    }
}