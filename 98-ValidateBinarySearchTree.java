// 98. Validate Binary Search Tree

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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
        
        public boolean isValid(TreeNode root, Integer MIN, Integer MAX) {
            if (root == null) {
                return true;
            }
            
            // first condition is for right sub tree, the min element of the right should be greater than the root
            // second condition is for left sub tree, maximum value of left sub tree should still be lesser than the root
            if ((MIN != null && root.val <= MIN) || (MAX != null && root.val >= MAX)) { 
                return false;
            }
          
            // first condition for the left sub tree, MIN can be anything but max is root value - nothing can exceed root's value
            // second condition for the right sub tree, MAX can be anything, but min is root value - min has to be higher than root's value 
            return isValid(root.left, MIN, root.val) && isValid(root.right, root.val, MAX);
        }
}
            