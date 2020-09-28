// 94. Binary Tree Inorder Traversal 

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

// Recursive Solution 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        return inOrder(root, outputList);  
    }
    
        public List<Integer> inOrder(TreeNode root, List<Integer> outputList) {       
            if (root == null) {
                return outputList;
            }
        
            inOrder(root.left, outputList );
            outputList.add(root.val);
            inOrder(root.right, outputList);
        
            return outputList;
        }
}

// Iterative solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        
        if (root == null) {
            return outputList;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
           if (curr != null) {
               stack.push(curr);
               curr = curr.left;
           } else {
               TreeNode pop = stack.pop();
               outputList.add(pop.val);
               curr = pop.right;
           }
            
        }
         return outputList;
    }
}
