// 144. Binary Tree Preorder Traversal

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
// PRE-ORDER (Node, Left, Right)
// recursive solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        return preOrder(root, outputList);
    }
        
        public List<Integer> preOrder(TreeNode root, List<Integer> outputList) {
            if (root == null) {
                return outputList;
            }
            
            outputList.add(root.val);
            preOrder(root.left, outputList);
            preOrder(root.right, outputList);
            
            return outputList;
        }
}

// PRE-ORDER (Node, Left, Right)
// Iterative solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        
        if (root == null) {
            return outputList;
        }
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            outputList.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }           
        }
        
        return outputList;
    }
}