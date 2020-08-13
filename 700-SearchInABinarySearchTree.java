// 700. Search in a Binary Search Tree
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        TreeNode current = root;
        while (current != null) {
            if (val == current.val) {
                return current;
            } else if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            }
        }    
        
        return null;
    }
}