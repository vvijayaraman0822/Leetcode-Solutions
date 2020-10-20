// 145. Binary Tree Postorder Traversal

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
// Post Order = Left, Right, Node
// Recursive Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        return postOrder(root, outputList);
    }
        
        public List<Integer> postOrder(TreeNode root, List<Integer> outputList) {
            if (root == null) {
                return outputList;
            }
            
            postOrder(root.left, outputList );
            postOrder(root.right, outputList);
            outputList.add(root.val);
            
            return outputList;
        }
}

// Iterative Solution
// POST-ORDER (Left, right, Node);
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        
        if (root == null) {
            return outputList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();   
            outputList.add(0, pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        
        return outputList;
    }
}

// Iterative Solution using two stacks 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        
        if (root == null) {
            return outputList;
        }
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        while(!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);
            
            if (pop.left != null) {
              s1.push(pop.left);  
            }
            
            if (pop.right != null) {
              s1.push(pop.right);  
            }
            
        }
        
        while(!s2.isEmpty()) {
           outputList.add(s2.pop().val);
        }
        
        return outputList;
    }
}


