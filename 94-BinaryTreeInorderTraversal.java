/**
// 94. Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
         Stack<TreeNode> preOrderStack = new Stack<>();
         List<Integer> finalList = new ArrayList<>();
        
        TreeNode current = root;
        while(current != null || !preOrderStack.isEmpty()) {
            while(current != null) {
            preOrderStack.push(current);
            current = current.left;
        }
        
        current = preOrderStack.pop();
        finalList.add(current.val); 
        current = current.right;    
        }    
    return finalList;
    }
}
