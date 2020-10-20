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
 // Recursive solution by flipping the left and right nodes
class Solution {
    public TreeNode invertTree(TreeNode root) {       
        if (root == null) {
            return null;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
    
        return root;
        
    }
}

// Iterative version flipping left and right nodes
class Solution {
    public TreeNode invertTree(TreeNode root) {       
        if (root == null) {
            return null;
        }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root); 
        
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll(); 
            
            if (curr.right != null) {
               queue.add(curr.right);  
            }
            
            if (curr.left != null) {
                queue.add(curr.left);
            }     
            
            // switch left and right nodes
            TreeNode temp = curr.right;
            curr.right = curr.left;
            curr.left = temp; 
            
        }
        
        return root;
    }
}